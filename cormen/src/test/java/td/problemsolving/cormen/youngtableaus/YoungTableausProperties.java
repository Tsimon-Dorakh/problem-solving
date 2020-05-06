package td.problemsolving.cormen.youngtableaus;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.internal.generator.ArrayGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static td.problemsolving.cormen.youngtableaus.YoungTableaus.print;
import static td.problemsolving.cormen.youngtableaus.YoungTableausFn.*;

@RunWith(JUnitQuickcheck.class)
public class YoungTableausProperties {
    @Property
    public void createProperty(@InRange(minInt = 0, maxInt = 1000)
                               int @Size(min = 20, max = 20)[] @Size(min = 20, max = 20)[] xss) {
        YoungTableaus youngTableaus = create(xss);
//        YoungTableaus youngTableaus = create(new int[][]{new int[]{735, 735}, new int[]{879, 734}});


        assertTrue(isYoungTableaus(youngTableaus));
    }

    @Property
    public void youngTableausProperty(@From(YoungTableausGenerator.class)
                                      @Size(min = 0, max = 20)
                                      @InRange(minInt = 0, maxInt = 1000) YoungTableaus youngTableaus) {
        assertTrue(isYoungTableaus(youngTableaus));

        print(youngTableaus);
    }

    @Property
    public void insertKeepsYoungTableausProperty(@From(YoungTableausGenerator.class)
                                                 @Full(FullType.NOT_FULL)
                                                 @Size(max = 20)
                                                 @InRange(minInt = 0, maxInt = 1000) YoungTableaus youngTableaus,
                                                 @InRange(minInt = 0, maxInt = 1000) int value) {
        insert(youngTableaus, value);

        assertTrue(isYoungTableaus(youngTableaus));
    }

    @Property
    public void valueAppearsInYoungTableausAfterInsert(@From(YoungTableausGenerator.class)
                                                       @Full(FullType.NOT_FULL)
                                                       @Size(max = 20)
                                                       @InRange(minInt = 0, maxInt = 1000) YoungTableaus youngTableaus,
                                                       @InRange(minInt = 0, maxInt = 1000) int value) {
        print(youngTableaus);

        insert(youngTableaus, value);

        assertTrue(hasValue(youngTableaus, value));
    }

    @Property
    public void extractMinProperty(@From(YoungTableausGenerator.class)
                                   @InRange(minInt = 0, maxInt = 1000) YoungTableaus youngTableaus) {
        List<Integer> xs = new ArrayList<>();

        while (hasValues(youngTableaus)) {
            xs.add(extractMin(youngTableaus));

            assertTrue(isYoungTableaus(youngTableaus));
        }

        assertTrue(isSortedAscending(xs));
    }

    private boolean isSortedAscending(List<Integer> xs) {
        for (int i = 1; i < xs.size(); i++) {
            if (xs.get(i - 1) > xs.get(i)) return false;
        }

        return true;
    }

    private boolean isYoungTableaus(YoungTableaus youngTableaus) {
        for (int i = 0; i < youngTableaus.xss.length; i++) {
            for (int j = 1; j < youngTableaus.xss[0].length; j++) {
                if (youngTableaus.xss[i][j - 1] > youngTableaus.xss[i][j])
                    return false;
            }
        }

        for (int j = 0; j < youngTableaus.xss[0].length; j++) {
            for (int i = 1; i < youngTableaus.xss.length; i++) {
                if (youngTableaus.xss[i - 1][j] > youngTableaus.xss[i][j])
                    return false;
            }
        }

        return true;
    }
}
