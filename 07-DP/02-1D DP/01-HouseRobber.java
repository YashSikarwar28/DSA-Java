//The observation is that we have to preform either the take/not take operation on the array, if we take jump 2 index otherwise one index 
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1){
                take+=dp[i-2];
            }
            int not_take=0+dp[i-1];
            dp[i]=Math.max(take,not_take);
        }
        return dp[nums.length-1];
    }

    // private int check(int[] nums, int ind, int sum, int[] dp) {
    //     if (ind == nums.length - 1)
    //         return nums[nums.length - 1];
    //     if (ind >= nums.length)
    //         return 0;
    //     if (dp[ind] != -1)
    //         return dp[ind];
    //     int take = nums[ind] + check(nums, ind + 2, sum + nums[ind], dp);
    //     int not_take = 0 + check(nums, ind + 1, sum, dp);
    //     return dp[ind] = Math.max(take, not_take);
    // }
}
