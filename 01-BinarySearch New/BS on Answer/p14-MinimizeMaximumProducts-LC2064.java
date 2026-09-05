//Similar to koko
class Solution {
    public int minimizedMaximum(int n, int[] a) {
        int l=1;
        int h=Arrays.stream(a).max().getAsInt();
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(check(n,a,mid)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int n,int[] a,int mid){
        int stores=0;
        for(int i=0;i<a.length;i++){
            //stores+=Math.ceil(a[i]/mid) - Slow syntax use the down one
            stores+=(a[i]+mid-1)/mid;
            if(stores>n) return false;
        }
        return true;
    }
}
