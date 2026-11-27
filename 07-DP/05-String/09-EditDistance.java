class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}



class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    private int check(String word1, String word2, int i, int j, int[][] dp) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            return check(word1, word2, i - 1, j - 1, dp);
        }
        int insert = 1 + check(word1, word2, i, j - 1, dp);
        int delete = 1 + check(word1, word2, i - 1, j, dp);
        int replace = 1 + check(word1, word2, i - 1, j - 1, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
}
