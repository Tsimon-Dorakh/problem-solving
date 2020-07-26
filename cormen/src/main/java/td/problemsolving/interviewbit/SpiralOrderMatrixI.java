package td.problemsolving.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Order Matrix I
 * https://www.interviewbit.com/problems/spiral-order-matrix-i/
 */
public class SpiralOrderMatrixI {
    public List<Integer> spiralOrder(final List<List<Integer>> xss) {
        List<Integer> result = new ArrayList<>();

        Step step = new Step(xss.get(0).size() - 1, xss.size() - 1, 0, 0, 0, 1, 0);

        for (int i = 0; i < xss.size() * xss.get(0).size(); i++) {
            result.add(xss.get(step.y).get(step.x));
            step = nextStep(step);
        }

        return result;
    }

    Step nextStep(Step step) {
        Step nextStep;

        if (step.dx == 1) {
            if (step.x + step.dx <= step.hi_x - step.level) {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x + 1, step.y, step.dx, step.dy);
            } else {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x, step.y + 1, 0, 1);
            }
        } else if (step.dy == 1) {
            if (step.y + step.dy <= step.hi_y - step.level) {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x, step.y + 1, step.dx, step.dy);
            } else {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x - 1, step.y, -1, 0);
            }
        } else if (step.dx == -1) {
            if (step.x + step.dx >= step.level) {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x - 1, step.y, step.dx, step.dy);
            } else {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x, step.y - 1, 0, -1);
            }
        } else {
            if (step.y + step.dy >= step.level + 1) {
                nextStep = new Step(step.hi_x, step.hi_y, step.level, step.x, step.y - 1, step.dx, step.dy);
            } else {
                nextStep = new Step(step.hi_x, step.hi_y, step.level + 1, step.x + 1, step.y, 1, 0);
            }
        }

        if (nextStep.level <= nextStep.x && nextStep.x <= nextStep.hi_x - nextStep.level &&
                nextStep.level <= nextStep.y && nextStep.y <= nextStep.hi_y - nextStep.level) {
            return nextStep;
        } else {
            return null;
        }
    }

    static class Step {
        int hi_x;
        int hi_y;
        int level;
        int x;
        int y;
        int dx;
        int dy;

        public Step(int hi_x, int hi_y, int level, int x, int y, int dx, int dy) {
            this.hi_x = hi_x;
            this.hi_y = hi_y;
            this.level = level;
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }
    }
}
