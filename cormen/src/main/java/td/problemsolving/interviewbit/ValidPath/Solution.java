package td.problemsolving.interviewbit.ValidPath;

/**
 * Valid Path
 * https://www.interviewbit.com/problems/valid-path/
 */
public class Solution {
    public String solve(int x, int y, int N, int R, int[] xs, int[] ys) {
        return canReach(xs, ys, R, new int[y + 1][x + 1], x, y, 0, 0) ? "YES" : "NO";
    }

    boolean canReach(int[] xs, int[] ys, int R, int[][] visited, int destX, int destY, int currentX, int currentY) {
        if (currentX < 0 || currentX >= visited[0].length || currentY < 0 || currentY >= visited.length) return false;
        if (isInsideCircle(xs, ys, R, currentX, currentY)) return false;
        if (visited[currentY][currentX] == 1) return false;
        if (destX == currentX && destY == currentY) return true;

        visited[currentY][currentX] = 1;

        boolean result = false;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;

                result = result || canReach(xs, ys, R, visited, destX, destY, currentX + dx, currentY + dy);
            }
        }

        return result;
    }

    boolean isInsideCircle(int[] xs, int[] ys, int R, int x, int y) {
        for (int i = 0; i < xs.length; i++) {
            int dx = xs[i] - x;
            int dy = ys[i] - y;

            if (dx*dx + dy*dy <= R*R) return true;
        }

        return false;
    }

    void show(int R, int[] xs, int[] ys, int width, int height, int destX, int destY) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == destX && y == destY) {
                    System.out.print("X ");
                } else {
                    System.out.printf("%d ", isInsideCircle(xs, ys, R, x, y) ? 1 : 0);
                }

            }

            System.out.println();
        }
    }
}
