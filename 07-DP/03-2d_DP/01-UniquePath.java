class Solution {
    public int uniquePaths(int m, int n) {
        //int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            //Arrays.fill(arr[i], 0);
            Arrays.fill(dp[i], 0);
        }
        return paths(m, n, dp, 0, 0);
    }

    private int paths(int m, int n, int[][] dp, int i, int j) {
        if (i >= m || j >= n || dp[i][j] == 1)
            return 0;
        if (i == m - 1 || j == n - 1)
            return 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        int l = paths(m, n, dp, i + 1, j);
        int r = paths(m, n, dp, i, j + 1);
        return dp[i][j] = l + r;
    }
}
