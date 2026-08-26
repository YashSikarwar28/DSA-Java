//We will use sliding window syntax running a default loop and a pointer at start if the conditons are fullfilled or exceeds then we will move the start pointer ahead. In this question when count becomes equal to 3 we will compare the string with the original string and update accodingly and if count exceeds then we will start removing zero or ones from start. 
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int count=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            //count exceeds
            while(j<=i && (count>k || s.charAt(j)=='0')){
                if(s.charAt(j)=='1'){
                    count--;
                }
                j++;
            }
            //comparing the string
            if(count==k){
                String temp=s.substring(j,i+1);
                if(ans.isEmpty() || temp.length()<ans.length() || (temp.length() == ans.length() && temp.compareTo(ans)<0)){
                    ans=temp;
                }
            }
        }
        return ans;
    }
}
