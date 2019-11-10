package sim.week7;

public class UniqueBST {
    // 해답봄..
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int lev = 2; lev <= n; lev++) {
            for (int root = 1; root <= lev; root++) {
                dp[lev] += dp[lev - root] * dp[root - 1];
            }
        }

        return dp[n];
    }

}
