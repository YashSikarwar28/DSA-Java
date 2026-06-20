// LC 136
class Solution {
    public int singleNumber(int[] a) {
        int ans=0;
        for(int i=0;i<a.length;i++){
            ans = ans ^ a[i];
        }
        return ans;
    }
}