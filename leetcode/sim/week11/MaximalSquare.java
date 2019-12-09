class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int[][] map = new int[matrix.length][matrix[0].length];
        
        int maxNum = 0;
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                map[0][i] = 1; 
                maxNum = 1;
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                map[i][0] = 1;
                maxNum = 1;
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    map[i][j] = 0;
                    continue;
                }
                
                int minNum = Math.min(Math.min(map[i][j-1], map[i-1][j]), map[i-1][j-1]);
                map[i][j] = minNum + 1;
                
                maxNum = Math.max(maxNum, map[i][j]);
            }
        }
        
        return maxNum * maxNum;
    }
}
