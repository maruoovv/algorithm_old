class Solution {
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        int xLen = grid.length;
        
        if (xLen == 0) return 0;
        
        int yLen = grid[0].length;
        
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        boolean[][] isVisited = new boolean[xLen][yLen];
        int cnt = 0;
        
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == '1' && isVisited[i][j] == false) {
                    cnt++;
                    queue.add(new Point(i, j));
                    
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        
                        int x = p.x;
                        int y = p.y;
                        
                        for (int d = 0; d < 4; d++) {
                            int tx = x + dx[d];
                            int ty = y + dy[d];
                          
                            if (tx < 0 || ty < 0 || tx >= xLen || ty >= yLen || grid[tx][ty] == '0' || isVisited[tx][ty]) continue;
                            
                            isVisited[tx][ty] = true;
                            queue.add(new Point(tx, ty));
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
}
