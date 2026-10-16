//Explore the down and right position and keep upadting the min value while you return, easy and basic code nothing complicated.
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                int d = grid[i][j] + ((i > 0) ? dp[i - 1][j] : (int) 1e9);
                int r = grid[i][j] + ((j > 0) ? dp[i][j - 1] : (int) 1e9);
                dp[i][j] = Math.min(d, r);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

// Memoization
// class Solution {
//     public int minPathSum(int[][] grid) {
//         int[][] dp = new int[grid.length][grid[0].length];
//         for (int i = 0; i < grid.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }
//         return check(grid, 0, 0, dp);
//     }

//     private int check(int[][] grid, int i, int j, int[][] dp) {
//         if (i >= grid.length || j >= grid[0].length)
//             return (int) 1e9;
//         if (i == grid.length - 1 && j == grid[0].length - 1)
//             return grid[i][j];
//         if (dp[i][j] != -1)
//             return dp[i][j];
//         int r = grid[i][j] + check(grid, i, j + 1, dp);
//         int d = grid[i][j] + check(grid, i + 1, j, dp);
//         return dp[i][j] = Math.min(r, d);
//     }
// }


// Recursion
// class Solution {
//     public int minPathSum(int[][] grid) {
//         return explore(grid, 0, 0);
//     }

//     private int explore(int[][] grid, int i, int j) {
//         if (i >= grid.length || j >= grid[0].length)
//             return (int)1e9;
//         //ans += grid[i][j];
//         if (i == grid.length - 1 && j == grid[0].length - 1) {
//             return grid[i][j];
//         }
//         int right = grid[i][j] + explore(grid, i, j + 1);
//         int down = grid[i][j] + explore(grid, i + 1, j);
//         return Math.min(right, down);
//     }
// }
