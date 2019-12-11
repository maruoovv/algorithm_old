class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length;
        
        if (m == 0) return false;
        
        int n = matrix[0].length;
        
        if (n == 0) return false;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <= target && matrix[i][n-1] >= target) {
                if (Arrays.binarySearch(matrix[i], target) >= 0) return true;
            }
        }
        
        int[][] copy = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = matrix[j][i];
            }
        }
        
         for (int i = 0; i < n; i++) {
            if (copy[i][0] <= target && copy[i][m-1] >= target) {
                if (Arrays.binarySearch(copy[i], target) >= 0) return true;
            }
        }
        
        return false;
    }
}
