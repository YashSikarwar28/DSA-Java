//We will use the typical int pick,not pick concept to solve this question
class Solution {
	static int perfectSum(int[] arr, int target) {
		int[][] dp = new int[arr.length + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j <= target; j++) {
				int not_take = dp[i - 1][j];
				int take = 0;
				if (arr[i - 1] <= j) {
					take = dp[i - 1][j - arr[i-1]];
				}
				dp[i][j] = take + not_take;
			}
		}
		return dp[arr.length][target];
	}
}



class Solution {
	static int perfectSum(int[] arr, int target) {
		int[][] dp=new int[arr.length+1][target+1];
		for(int i=0;i<arr.length;i++){
		    Arrays.fill(dp[i],-1);
		}
		return check(arr, target, 0,dp);
	}
	private static int check(int[] arr, int target, int ind,int[][] dp) {
		if (ind == arr.length) {
			return target == 0?1:0;
		}
		if(dp[ind][target]!=-1) return dp[ind][target];
		int not_pick = check(arr, target, ind + 1,dp);
		int pick = 0;
		if (arr[ind] <= target) {
			pick = check(arr, target - arr[ind], ind + 1,dp);
		}
		return dp[ind][target]=pick + not_pick;
	}
}
