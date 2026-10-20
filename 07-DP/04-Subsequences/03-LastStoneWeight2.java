//The main logic is that we are given an array, we have to split it into 2 half with the differnce being the lowest.
//For that we will first use the subset logic of picking one and leaving another to find the smallest for one half of the array, for the other half we can subtract from the total sum which we can easily caluclate and return the minimum value.
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = Arrays.stream(stones).sum();
        boolean[][] dp = new boolean[stones.length + 1][total + 1];
        //base case
        for (int i = 0; i <= stones.length; i++) {
            dp[i][0] = true;
        }
        //tabulation loop
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= total; j++) {
                boolean not_take = dp[i - 1][j];
                boolean take = false;
                if (j >= stones[i - 1]) {
                    take = dp[i - 1][j - stones[i - 1]];
                }
                dp[i][j] = take || not_take;
            }
        }
        //loop only through half value 
        int target = total / 2;
        for (int i = target; i >= 0; i--) {
            if (dp[stones.length][i]) {
                return total - 2 * i;
            }
        }
        return 0;
    }
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        //ind,sum
        int[][] dp = new int[stones.length][4000];
        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int total = Arrays.stream(stones).sum();
        return check(stones, 0, total, 0, dp);
    }

    private int check(int[] stones, int ind, int total, int sum1, int[][] dp) {
        if (ind == stones.length) {
            int sum2 = total - sum1;
            return Math.abs(sum1 - sum2);
        }
        if (dp[ind][sum1] != -1)
            return dp[ind][sum1];
        int not_take = check(stones, ind + 1, total, sum1, dp);
        int take = check(stones, ind + 1, total, sum1 + stones[ind], dp);
        return dp[ind][sum1] = Math.min(take, not_take);
    }
}
