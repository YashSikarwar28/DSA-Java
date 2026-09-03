//Take k from one end and then take k from the other end and get the max.
class Solution {
    public int maxScore(int[] a, int k) {
        int lsum=0;
        int rsum=0;
        int maxsum=0;
        for(int i=0;i<=k-1;i++){
            lsum+=a[i];
        }
        maxsum=lsum;
        int rind=a.length-1;
        for(int i=k-1;i>=0;i--){
            lsum=lsum-a[i];
            rsum=rsum+a[rind];
            rind--;
           maxsum=Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}
