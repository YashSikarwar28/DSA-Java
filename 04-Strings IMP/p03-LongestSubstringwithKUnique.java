//We will check for conditions : by default we will put the characters and increase the count and then if count > k we will remove characters from start and when the start character count=0 we will remove that particular character and the size decreases. When size==k we will calculate the max length.
class Solution {
    public int longestKSubstr(String s, int k) {
        HashMap<Character,Integer> hs=new HashMap<>();
        int j=0;
        int len=-1;
        for(int i=0;i<s.length();i++){
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            if(hs.size()>k){
                hs.put(s.charAt(j),hs.get(s.charAt(j))-1);
                if(hs.get(s.charAt(j))==0){
                    hs.remove(s.charAt(j));
                }
                j++;
            }
            if(hs.size()==k){
                len=Math.max(len,i-j+1);
            }
        }
        return len;
    }
}
