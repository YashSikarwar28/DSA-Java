//Find the LCS using tabulation, then loop in the tabulation table from the end if matches decrease b0th the values else decrease the onc which is maximum
public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp=new int[s1.length+1][s2.length+1];
        //s1 -> i, s2 -> j
        for(int i=0;i<=s1.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=s2.length();j++){
            dp[0][j]=0;
        }
        //tabulation loop
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        //printing
        StringBuilder ans=new StringBuilder();
        int i=s1.length();
        int j=s2.length();
        while(i>0 && j>0){
            //intitailly i wrote this : if(dp[i-1][j]==dp[i][j-1])
            if(s1.charAt(i-1)==s2(j-1)){
                    ans.append(s1.charAt(i-1));
                    i--;
                    j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return ans.reverse().toString();
    }
