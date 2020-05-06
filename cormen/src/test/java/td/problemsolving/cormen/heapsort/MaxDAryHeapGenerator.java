package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static com.pholser.junit.quickcheck.internal.Ranges.Type.INTEGRAL;
import static com.pholser.junit.quickcheck.internal.Ranges.checkRange;
import static com.pholser.junit.quickcheck.internal.Reflection.defaultValueOf;

public class MaxDAryHeapGenerator extends Generator<MaxDAryHeap> {
    private Size lengthRange;
    private int min = 0;
    private int max = (Integer) defaultValueOf(InRange.class, "maxInt");

    public MaxDAryHeapGenerator() {
        super(MaxDAryHeap.class);
    }

    public void configure(Size size) {
        this.lengthRange = size;
        checkRange(INTEGRAL, size.min(), size.max());
    }

    public void configure(InRange range) {
        min = range.min().isEmpty() ? range.minInt() : Integer.parseInt(range.min());
        max = range.max().isEmpty() ? range.maxInt() : Integer.parseInt(range.max());
    }

    @Override
    public MaxDAryHeap generate(SourceOfRandomness random, GenerationStatus status) {
        int length = length(random, status);
        int d = random.nextInt(1, Math.max(1, length));

        int[] xs = new int[length];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = random.nextInt(min, max);
        }

        return MaxDAryHeap.buildMaxHeap(xs, d);
    }

    protected int length(SourceOfRandomness random, GenerationStatus status) {
        return lengthRange != null
                ? random.nextInt(lengthRange.min(), lengthRange.max())
                : status.size();
    }

}
