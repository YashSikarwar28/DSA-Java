//Tabulation Method -> we will follow the shifting index pattern.
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        //base case
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

//Memoization using shifting
// shifting index : i=i-1, j=j-1, 0->-1, 3->2, length->length-1
// shifting right by 1
//This concept would be used in tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];;
        for(int i=0;i<=text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        //1 means 0
        return check(1,1,dp,text1,text2);
    }
    private int check(int i,int j,int[][] dp,String text1,String text2){   
        //text.length()+1 means text.length() 
        if(i==text1.length()+1 || j==text2.length()+1){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            return 1+check(i+1,j+1,dp,text1,text2);
        }
        return dp[i][j]= Math.max(check(i+1,j,dp,text1,text2),check(i,j+1,dp,text1,text2));
    }
}

//Memoization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int len = Math.max(text1.length(), text2.length());
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcs(0, 0, text1, text2, dp);
    }

    private int lcs(int i, int j, String text1, String text2, int[][] dp) {
        if (i == text1.length() || j == text2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i + 1, j + 1, text1, text2, dp);
        }
        return dp[i][j] = Math.max(lcs(i + 1, j, text1, text2, dp), lcs(i, j + 1, text1, text2, dp));
    }
}

//Recursion
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(0,0,text1,text2);
    }
    private int lcs(int i,int j,String text1, String text2){
        if(i==text1.length() || j==text2.length()) return 0;
        int match=0;
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+lcs(i+1,j+1,text1,text2);
        }
        return Math.max(lcs(i+1,j,text1,text2),lcs(i,j+1,text1,text2));
    }
}
