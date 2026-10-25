//In this question we have to find the number of different ways how we can achieve our target, we can use index any number of times.
//Tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;
                if (coins[i] <= j) {
                    take = dp[i][j - coins[i]];
                }
                dp[i][j] = take + not_take;
            }
        }
        return dp[coins.length - 1][amount];
    }
}

//Memoization
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(amount, coins, dp, 0);
    }

    private int check(int amount,int[] coins,int[][] dp,int ind){
        if(ind==coins.length){
            return (amount==0)?1:0;
        }
        int not_take=check(amount,coins,dp,ind+1);
        int take=0;
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        if(coins[ind]<=amount){
            take=check(amount-coins[ind],coins,dp,ind);
        }
        return dp[ind][amount]=take+not_take;
    }
}

//Recursion
class Solution {
    public int change(int amount, int[] coins) {
        return check(amount, coins, 0);
    }

    private int check(int amount, int[] coins, int ind) {
        if (ind == coins.length) {
            return (amount == 0) ? 1 : 0;
        }
        int not_Take = check(amount, coins, ind + 1);
        int take = 0;
        if (coins[ind] <= amount) {
            take = check(amount - coins[ind], coins, ind);
        }
        return take + not_Take;
    }
}
