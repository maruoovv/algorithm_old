package week6;


public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		return dfs(grid, 0, 0, 0, -1, grid.length - 1, grid[0].length - 1);
	}

	private int dfs(int[][] grid, int i, int j, int sum, int min, int m, int n) {
		sum += grid[i][j];
		if (min != -1 && min < sum - (m - i + j - n))
			return min;

		if (i == m && j == n) {
			if (sum < min || min == -1) {
				return sum;
			}
		} else {

			if (j < n) {
				min = dfs(grid, i, j + 1, sum, min, m, n);
			}
			if (i < m) {
				min = dfs(grid, i + 1, j, sum, min, m, n);
			}
		}

		return min;
	}
}
