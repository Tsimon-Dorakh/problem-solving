package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static com.pholser.junit.quickcheck.internal.Ranges.Type.INTEGRAL;
import static com.pholser.junit.quickcheck.internal.Ranges.checkRange;
import static com.pholser.junit.quickcheck.internal.Reflection.defaultValueOf;

public class MaxBinaryHeapGenerator extends Generator<MaxBinaryHeap> {
    private Size lengthRange;
    private int min = (Integer) defaultValueOf(InRange.class, "minInt");
    private int max = (Integer) defaultValueOf(InRange.class, "maxInt");

    public MaxBinaryHeapGenerator() {
        super(MaxBinaryHeap.class);
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
    public MaxBinaryHeap generate(SourceOfRandomness random, GenerationStatus status) {
        int length = length(random, status);

        int[] xs = new int[length];

        for (int i = 0; i < xs.length; i++) {
            xs[i] = random.nextInt(min, max);
        }

        return MaxBinaryHeap.buildMaxHeap(xs);
    }

    protected int length(SourceOfRandomness random, GenerationStatus status) {
        return lengthRange != null
                ? random.nextInt(lengthRange.min(), lengthRange.max())
                : status.size();
    }
}
