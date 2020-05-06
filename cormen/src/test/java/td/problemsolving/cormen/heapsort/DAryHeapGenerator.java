package td.problemsolving.cormen.heapsort;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class DAryHeapGenerator extends Generator<DAryHeap> {
    public DAryHeapGenerator() {
        super(DAryHeap.class);
    }

    @Override
    public DAryHeap generate(SourceOfRandomness random, GenerationStatus status) {
        int d = random.nextInt(1, 10);

        return new DAryHeap(d);
    }
}
