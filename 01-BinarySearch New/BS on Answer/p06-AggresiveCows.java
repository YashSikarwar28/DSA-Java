class Solution {
    public int aggressiveCows(int[] a, int k) {
        Arrays.sort(a);
        int l=1;
        int h=a[a.length-1]-a[0];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(place(a,mid,k)){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return h;
    }
    private boolean place(int[] a,int mid,int k){
        int cows=1;
        int dist=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]-dist>=mid){
                cows++;
                dist=a[i];
            }
            if(cows>=k) return true;
        }
        return false;
    }
}