//Variation of LCS, when the character dont match put 0 because we need character in sequence.
//For max length we can simply iterate in loop and get the max value or update in the tabulation loop itself like its there in the code.
class Solution {
	public int longCommSubstr(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= s2.length(); i++) {
			dp[0][i] = 0;
		}
		int ans = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
          //updating the length
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return ans;
	}
}
