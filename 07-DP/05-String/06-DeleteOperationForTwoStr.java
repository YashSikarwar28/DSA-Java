//Compare 2 string and find LCS, similar to what we have done in previous questions
//Only difference is that here we have to subtract the word1 length and word2 length from LCS length -> then add both the length to get the answer because in this we have to find insertion and dletion both.
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = check(word1, word2, word1.length() - 1, word2.length() - 1, dp);
        int deletion = word1.length() - ans;
        int insertion = word2.length() - ans;
        return deletion + insertion;
    }

    public int check(String word1, String word2, int i, int j, int[][] dp) {
        if (i == -1 || j == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + check(word1, word2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(check(word1, word2, i - 1, j, dp), check(word1, word2, i, j - 1, dp));
    }
}

//Tabulation
class Solution {
    public int minDistance(String s, String s2) {
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
        int deletion = s.length() - dp[s.length()][s2.length()];
        int insertion = s2.length() - dp[s.length()][s2.length()];
        return insertion + deletion;
    }
}


class Solution {
    public int minDistance(String s, String s2) {
        int ans = check(s, s2, s.length() - 1, s2.length() - 1);
        int deletion = s.length() - ans;
        int insertion = s2.length() - ans;
        return insertion + deletion;
    }

    private int check(String s, String s2, int i, int j) {
        if (i == -1 || j == -1)
            return 0;
        if (s.charAt(i) == s2.charAt(j)) {
            return 1 + check(s, s2, i - 1, j - 1);
        }
        return Math.max(check(s, s2, i - 1, j), check(s, s2, i, j - 1));
    }
}
