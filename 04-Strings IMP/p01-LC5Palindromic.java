//From every index of string we will go left and right and check if characters are equal or not also take a note of even and odd indices. and update the string accordingly.
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String palin="";
        for(int i=1;i<s.length();i++){
            //odd
            int j=i;
            int k=i;
            while(s.charAt(j)==s.charAt(k)){
                j--;
                k++;
                if(j==-1 || k==s.length()){
                    break;
                }
            }
            String str=s.substring(j+1,k);
            if(str.length()>palin.length()){
                palin=str;
            }
            //even
            j=i-1;
            k=i;
            while(s.charAt(j)==s.charAt(k)){
                j--;
                k++;
                if(j==-1 || k==s.length()){
                    break;
                }
            }
            str=s.substring(j+1,k);
            if(str.length()>palin.length()){
                palin=str;
            }
        }
        return palin;
    }
}
