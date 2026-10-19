//For equal partition we will use the half divide concept, if the sum/2 is present in the array that means its true otherwise false

class Solution {
    public boolean canPartition(int[] nums) {
        int tar = Arrays.stream(nums).sum();
        if (tar % 2 != 0)
            return false;
        boolean[][] dp = new boolean[nums.length + 1][tar + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        tar = tar / 2;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= tar; j++) {
                boolean not_take = dp[i - 1][j];
                boolean take = false;
                if (nums[i - 1] <= j) {
                    take = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = take || not_take;
            }
        }
        return dp[nums.length - 1][tar];
    }
}



class Solution {
    public boolean canPartition(int[] arr) {
        int tar = Arrays.stream(arr).sum();
        //odd sum array
        if ((tar & 1) != 0)
            return false;

        int[][] dp = new int[arr.length + 1][tar + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(arr, 0, tar, 0, dp);
    }

    private boolean check(int[] arr, int sum, int tar, int ind, int[][] dp) {
        if (sum == tar / 2)
            return true;
        if (ind == arr.length)
            return false;
        if (dp[ind][sum] != -1)
            return dp[ind][sum] == 1;
        boolean not_take = check(arr, sum, tar, ind + 1, dp);
        boolean take = false;
        if (arr[ind] <= tar / 2) {
            take = check(arr, sum + arr[ind], tar, ind + 1, dp);
        }
        dp[ind][sum] = (take || not_take) ? 1 : 0;
        return dp[ind][sum] == 1;
    }
}
