class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}


class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(s.length() - 1, t.length() - 1, s, t, dp);
    }

    private int check(int i, int j, String s, String t, int[][] dp) {
        if (j == -1)
            return 1;
        if (i == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        //character matching
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = check(i - 1, j - 1, s, t, dp) + check(i - 1, j, s, t, dp);
        }
        //not matching
        return dp[i][j] = check(i - 1, j, s, t, dp);
    }
}
