//Find subsequence for sum, if exists return true otherwise false
//Have a look at the syntax as most of the sums would involve this syntax
class Solution {
	static boolean isSubsetSum(int arr[], int sum) {
    //index from 0 to length+1 and sum can be max upto sum+1
		boolean[][] dp = new boolean[arr.length + 1][sum + 1];
		// writing the base case
		// the target can be zero
		for (int i = 0; i<arr.length; i++) {
			dp[i][0] = true;
		}
		
		// i -> index, j -> sum
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				boolean not_take = dp[i - 1][j];
				boolean take = false;
				if (arr[i - 1] <= j) {
					take = dp[i - 1][j - arr[i - 1]];
				}
				dp[i][j] = take || not_take;
			}
		}
		return dp[arr.length][sum];
	}
}

//Memoization
class Solution {
	static boolean isSubsetSum(int arr[], int sum) {
		int[][] dp = new int[arr.length + 1][sum + 1];
		for (int i = 0; i<arr.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return sum(arr, sum, 0, dp);
	}
	private static boolean sum(int[] arr, int sum, int ind, int[][] dp) {
		if (sum == 0)
			return true;
		if (ind == arr.length - 1)
			return arr[arr.length - 1] == sum;
		if (dp[ind][sum] != -1)
			return dp[ind][sum] == 1;
		boolean not_take = sum(arr, sum, ind + 1, dp);
		boolean take = false;
		if (arr[ind] <= sum)
			take = sum(arr, sum - arr[ind], ind + 1, dp);
		dp[ind][sum] = (take || not_take) ? 1 : 0;
		return dp[ind][sum] == 1;
	}
}

//Recursion
class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        return sum(arr,sum,0);
    }
    private static boolean sum(int[] arr,int sum,int ind){
        if(sum==0) return true;
        if(ind==arr.length-1) return arr[arr.length-1]==sum;
        boolean not_take=sum(arr,sum,ind+1);
        boolean take=false;
        if(arr[ind]<=sum) take=sum(arr,sum-arr[ind],ind+1);
        return not_take || take;
    }
}
