//3d DP - means 3 variables will be involved which will change according to the calls
//Alice and Bob will always jump to the same row but their coloumn will change so we can have a variable common for row and 2 othere variables for coloumn for alice and bob respectively.
//If both jump on the same cell then only once the value will be added otherwise we will add the 2 different values
class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return sum(grid, 0, 0, grid[0].length - 1, dp);
    }

    private int sum(int[][] grid, int i, int j1, int j2, int[][][] dp) {
        if (i < 0 || j1 < 0 || j2 < 0 || i >= grid.length || j1 >= grid[0].length || j2 >= grid[0].length)
            return (int) -1e9;
        if (i == grid.length - 1) {
            //same jump
            if (j1 == j2)
                return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int max = 0;
        for (int k1 = -1; k1 <= 1; k1++) {
            int value = 0;
            for (int k2 = -1; k2 <= 1; k2++) {
                //same jump
                if (j1 == j2) {
                    value = grid[i][j1] + sum(grid, i + 1, j1 + k1, j2 + k2, dp);
                } else {
                    value = grid[i][j1] + grid[i][j2] + sum(grid, i + 1, j1 + k1, j2 + k2, dp);
                }
                max = Math.max(max, value);
            }
        }
        return dp[i][j1][j2] = max;
    }
}
