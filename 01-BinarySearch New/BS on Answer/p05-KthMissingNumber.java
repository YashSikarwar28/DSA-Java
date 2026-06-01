//First we need to calculate how many number are missing at that particular index, then compare that number with k and move the low and high pointer accordingly.

class Solution {
    public int findKthPositive(int[] a, int k) {
        int l=0;
        int r=a.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int n=a[mid]-(mid+1);
            if(n<k){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l+k;
    }
}