//Just reverse the original string and apply LCS on both the string 
class Solution {
    public int longestPalindromeSubseq(String s) {
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
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][s2.length()];
    }
}


//Memoization
class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder(s);
        int[][] dp = new int[s.length()][s2.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(s, s2.reverse().toString(), s.length() - 1, s2.length() - 1, dp);
    }

    private int check(String s, String s2, int i, int j, int[][] dp) {
        if (i == -1 || j == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + check(s, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(check(s, s2, i - 1, j, dp), check(s, s2, i, j - 1, dp));
    }
}
