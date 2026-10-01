//2d DP
//On one particular row we have 3 values from that we can take only one value which should be the max and it should be different from the previous value i.e. the value of previous and current should not be same.
class Solution {
	public int maximumPoints(int mat[][]) {
		int n = mat.length;
		int[][] dp = new int[n][4];
		for (int i = 0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return check(mat, 0, 3, dp);
	}
	private int check(int[][] mat, int ind, int choice, int[][] dp) {
		if (ind == mat.length) {
			return 0;
		}
		if (dp[ind][choice] != -1)
			return dp[ind][choice];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i<3; i++) {
			if (i != choice) {
				int points = mat[ind][i]+check(mat, ind + 1, i, dp);
				max = Math.max(max, points);
			}
		}
		return dp[ind][choice] = max;
	}
}
