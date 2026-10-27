//Given a value arr and weight arr and a threshold we have to take the max value upto the threshold.
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int[][] dp = new int[wt.length][capacity + 1];
		for (int i = 0; i <= capacity; i++) {
			dp[0][i] = (i/wt[0])*val[0];
		}
		for (int i = 1; i<wt.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				int not_take = dp[i - 1][j];
				int take = 0;
				if (wt[i] <= j) {
					take = val[i]+dp[i][j - wt[i]];
				}
				dp[i][j] = Math.max(take, not_take);
			}
		}
		return dp[wt.length - 1][capacity];
	}
}

//Memoization
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int[][] dp = new int[wt.length][capacity + 1];
		for (int i = 0; i<wt.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return check(val, wt, capacity, 0, dp);
	}
	private int check(int[] val, int[] wt, int capacity, int ind, int[][] dp) {
		if (ind == wt.length - 1) {
			return (capacity/wt[ind])*val[ind];
		}
		int not_take = check(val, wt, capacity, ind + 1, dp);
		if (dp[ind][capacity] != -1)
			return dp[ind][capacity];
		int take = 0;
		if (wt[ind] <= capacity) {
			take = val[ind]+check(val, wt, capacity - wt[ind], ind, dp);
		}
		return dp[ind][capacity] = Math.max(not_take, take);
	}
}
