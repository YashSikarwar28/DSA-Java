// 3D DP -> i,j,1024 size for storing the xor values
//This sum is slightly different from the sum in which we need to find the max/min and return the answer, size is fixed 1023.
//In this we need to keep a track of all the xor values upto a given index and then we need to do the xor of all those values with the current index value and mark them true.
//For storing value we run loop from 0 to 1024 and then do xor and mark them true
//At last we need to loop in the end row and col of the dp array and the first value which we find true we must return that. 
class Solution {
    public int minCost(int[][] grid) {
        boolean[][][] dp = new boolean[grid.length][grid[0].length][1024];
        dp[0][0][grid[0][0]] = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                //right direction
                if (j > 0) {
                    for (int xor = 0; xor < 1024; xor++) {
                        if (dp[i][j - 1][xor]) {
                            dp[i][j][grid[i][j] ^ xor] = true;
                        }
                    }
                }
                //down direction
                if (i > 0) {
                    for (int xor = 0; xor < 1024; xor++) {
                        if (dp[i - 1][j][xor]) {
                            dp[i][j][grid[i][j] ^ xor] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 1024; i++) {
            if (dp[grid.length - 1][grid[0].length - 1][i]) {
                return i;
            }
        }
        return -1;
    }
}


class Solution {
    public int minCost(int[][] grid) {
        for (int target = 0; target < 1024; target++) {
            if (check(grid, 0, 0, 0, target)) {
                return target;
            }
        }
        return -1;
    }

    private boolean check(int[][] grid, int i, int j, int xor, int target) {
        if (i >= grid.length || j >= grid[0].length) {
            return false;
        }
        xor = xor ^ grid[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return xor == target;
        }
        boolean right = check(grid, i, j + 1, xor, target);
        boolean down = check(grid, i + 1, j, xor, target);
        return right || down;
    }
}
