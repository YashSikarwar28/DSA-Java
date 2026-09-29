//The catch is that now the first and last index are neighbours, so we have to traverse from 0 to last-1 ot grom last to first.
//Maintaning 2 dp arrays for 2 conditions from start to end-1 and from end to start+1
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp1 = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        //From first house to last-1
        for (int i = 0; i < nums.length - 1; i++) {
            int take = nums[i] + (i >= 2 ? dp1[i - 2] : 0);
            int not_take = 0 + (i >= 1 ? dp1[i - 1] : 0);
            dp1[i] = Math.max(take, not_take);
        }
        //From last house to first house, exclude the zero house
        for (int i = nums.length - 1; i >= 1; i--) {
            int take = nums[i] + (i + 2 < nums.length ? dp2[i + 2] : 0);
            int not_take = 0 + dp2[i + 1];
            dp2[i] = Math.max(take, not_take);
        }
        return Math.max(dp1[nums.length - 2], dp2[1]);
    }
}

//Memoization

// class Solution {
//     public int rob(int[] nums) {
//         if(nums.length==1) return nums[0];
//         int[] dp1 = new int[nums.length + 1];
//         int[] dp2 = new int[nums.length + 1];
//         Arrays.fill(dp1,-1);
//         Arrays.fill(dp2,-1);
//         return Math.max(rob1(nums, 0, dp1), rob2(nums, nums.length - 1, dp2));
//     }

//     private int rob1(int[] nums, int ind, int[] dp1) {
//         if (ind >= nums.length - 1)
//             return 0;
//         if (dp1[ind] != -1)
//             return dp1[ind];
//         int pick = nums[ind] + rob1(nums, ind + 2, dp1);
//         int not_pick = 0 + rob1(nums, ind + 1, dp1);
//         return dp1[ind] = Math.max(pick, not_pick);
//     }

//     private int rob2(int[] nums, int ind, int[] dp2) {
//         if (ind <= 0)
//             return 0;
//         if (dp2[ind] != -1)
//             return dp2[ind];
//         int pick = nums[ind] + rob2(nums, ind - 2, dp2);
//         int not_pick = 0 + rob2(nums, ind - 1, dp2);
//         return dp2[ind] = Math.max(pick, not_pick);
//     }
// }

//Normal Recursion

// class Solution {
//     public int rob(int[] nums) {
//         return Math.max(rob1(nums, 0), rob2(nums, nums.length - 1));
//     }

//     private int rob1(int[] nums, int ind) {
//         if (ind >= nums.length)
//             return 0;
//         if (ind == nums.length - 1)
//             return 0;
//         int pick = nums[ind] + rob1(nums, ind + 2);
//         int not_pick = 0 + rob1(nums, ind + 1);
//         return Math.max(pick, not_pick);
//     }

//     private int rob2(int[] nums, int ind) {
//         if (ind == 0)
//             return 0;
//         if (ind < 0)
//             return 0;
//         int pick = nums[ind] + rob2(nums, ind - 2);
//         int not_pick = 0 + rob2(nums, ind - 1);
//         return Math.max(pick, not_pick);
//     }
// }
