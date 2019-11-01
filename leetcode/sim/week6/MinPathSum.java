package sim.week6;

import java.util.LinkedList;
import java.util.Queue;

public class MinPathSum {
    class Solution {
        class Point {
            int x, y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] minimumStep = new int[m][n];

            int dx[] = { 1, 0};
            int dy[] = { 0, 1};

            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(0, 0));
            minimumStep[0][0] = grid[0][0];

            while(!queue.isEmpty()) {
                Point point = queue.poll();

                for (int i = 0; i < 2; i++) {
                    int preX = point.getX();
                    int preY = point.getY();
                    int x = preX + dx[i];
                    int y = preY + dy[i];

                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }

                    if (minimumStep[x][y] == 0 || minimumStep[x][y] > minimumStep[preX][preY] + grid[x][y]) {
                        minimumStep[x][y] = minimumStep[preX][preY] + grid[x][y];
                        queue.add(new Point(x, y));
                    }
                }
            }

            return minimumStep[m-1][n -1];
        }
    }
}
