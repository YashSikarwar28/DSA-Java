//We are given a target we have to find the minimum number of coins it take to achieve the target.
//We can take a particular coin any number of times to achieve our target
//Take a look at the base case!!
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = (int) 1e9;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int not_Take = dp[i - 1][j];
                int take = (int) 1e9;
                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(take, not_Take);
            }
        }
        return (dp[coins.length - 1][amount] >= (int) 1e9) ? -1 : dp[coins.length - 1][amount];
    }
}

//Memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -4);
        }
        int ans = check(coins, amount, 0, dp);
        return (ans >= (int) 1e9) ? -1 : ans;
    }

    private int check(int[] coins, int amount, int ind, int[][] dp) {
        if (ind == coins.length - 1) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            }
            return (int) 1e9;
        }
        int not_take = check(coins, amount, ind + 1, dp);
        int take = (int) 1e9;
        if (dp[ind][amount] != -4)
            return dp[ind][amount];
        if (coins[ind] <= amount) {
            take = 1 + check(coins, amount - coins[ind], ind, dp);
        }
        return dp[ind][amount] = Math.min(take, not_take);
    }
}

//Recursion
class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = check(coins, amount, 0);
        return (ans >= (int) 1e9) ? -1 : ans;
    }

    private int check(int[] coins, int amount, int ind) {
        if (ind == coins.length - 1) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            }
            ;
            return (int) 1e9;
        }
        int not_Take = check(coins, amount, ind + 1);
        int take = (int) 1e9;
        if (coins[ind] <= amount) {
            take = 1 + check(coins, amount - coins[ind], ind);
        }
        return Math.min(take, not_Take);
    }
}
