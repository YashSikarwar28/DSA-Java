//Reverse the string -> apply Lcs on original and reversed -> Subtract the orginal length from the LCS length
class Solution {
    public int minInsertions(String s) {
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse().toString();
        int[][] dp = new int[s.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return s.length() - dp[s.length()][s2.length()];
    }
}
