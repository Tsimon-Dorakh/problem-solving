package td.problemsolving.cormen.youngtableaus;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.Arrays;

import static com.pholser.junit.quickcheck.internal.Ranges.Type.INTEGRAL;
import static com.pholser.junit.quickcheck.internal.Ranges.checkRange;
import static com.pholser.junit.quickcheck.internal.Reflection.defaultValueOf;

public class YoungTableausGenerator extends Generator<YoungTableaus> {
    private Size size;
    private int min = (Integer) defaultValueOf(InRange.class, "minInt");
    private int max = (Integer) defaultValueOf(InRange.class, "maxInt");
    private FullType fullType = (FullType) defaultValueOf(Full.class, "value");

    public YoungTableausGenerator() {
        super(YoungTableaus.class);
    }

    public void configure(Full full) {
        this.fullType = full.value();
    }

    public void configure(Size size) {
        this.size = size;
        checkRange(INTEGRAL, size.min(), size.max());
    }

    public void configure(InRange range) {
        min = range.min().isEmpty() ? range.minInt() : Integer.parseInt(range.min());
        max = range.max().isEmpty() ? range.maxInt() : Integer.parseInt(range.max());
    }

    @Override
    public YoungTableaus generate(SourceOfRandomness random, GenerationStatus status) {
        int[] xs = new int[length(random, status)];
        for (int i = 0; i < xs.length; i++) {
            xs[i] = random.nextInt(min, max);
        }

        YoungTableaus youngTableaus = new YoungTableaus();
        youngTableaus.m = random.nextInt(1, Math.max(1, xs.length));
//        youngTableaus.n = Math.max(1, (int) Math.ceil(1. * xs.length / youngTableaus.m));
        youngTableaus.n = calculateWidth(youngTableaus.m, xs.length);

        youngTableaus.xss = new int[youngTableaus.m][];
        for (int i = 0; i < youngTableaus.m; i++) {
            youngTableaus.xss[i] = new int[youngTableaus.n];
        }

        Arrays.sort(xs);

        for (int i = 0; i < youngTableaus.m; i++) {
            for (int j = 0; j < youngTableaus.n; j++) {
                if (i * youngTableaus.n + j < xs.length) {
                    youngTableaus.xss[i][j] = xs[i * youngTableaus.n + j];
                } else {
                    youngTableaus.xss[i][j] = YoungTableaus.INFINITY;
                }
            }
        }

        return youngTableaus;
    }

    private int calculateWidth(int height, int dataSize) {
        return Math.max(1, (int) Math.ceil(1. * dataSize / height)) +
                (fullType == FullType.NOT_FULL ? 1 : 0);
    }

    protected int length(SourceOfRandomness random, GenerationStatus status) {
        return size != null
                ? random.nextInt(size.min(), size.max())
                : Math.max(status.size(), 1);
    }

}
