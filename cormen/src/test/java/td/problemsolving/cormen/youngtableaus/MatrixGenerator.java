package td.problemsolving.cormen.youngtableaus;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import static com.pholser.junit.quickcheck.internal.Ranges.Type.INTEGRAL;
import static com.pholser.junit.quickcheck.internal.Ranges.checkRange;
import static com.pholser.junit.quickcheck.internal.Reflection.defaultValueOf;
import static java.util.Arrays.asList;

public class MatrixGenerator extends Generator<Object> {
    private Size size;
    private int min = (Integer) defaultValueOf(InRange.class, "minInt");
    private int max = (Integer) defaultValueOf(InRange.class, "maxInt");

    public MatrixGenerator() {
        super(Object.class);
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
    public Object generate(SourceOfRandomness random, GenerationStatus status) {
        return null;
    }
}
