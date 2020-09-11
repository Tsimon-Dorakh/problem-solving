package td.problemsolving.interviewbit.HotelReviews;

import com.mifmif.common.regex.Generex;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.List;

public class StringGenerator extends Generator<String> {
    public StringGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness random, GenerationStatus status) {
        int count = random.nextInt(1, 10);

        List<String> strings = new ArrayList<>();
        while (count-- > 0) {
            Generex regex = new Generex("[a-z]*", random.toJDKRandom());
            strings.add(regex.random(1, 1 + status.size()));
        }

        return String.join("_", strings);
    }
}
