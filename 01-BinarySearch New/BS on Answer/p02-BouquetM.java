class Solution {
    public int minDays(int[] a, int m, int k) {
        if(m*k>a.length) return -1;
        int s=Arrays.stream(a).min().getAsInt();
        int h=Arrays.stream(a).max().getAsInt();
        int ans=-1;
        while(s<=h){
            int mid=s+(h-s)/2;
            if(bloom(a,m,k,mid)){
                ans=mid;
                h=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
    private boolean bloom(int[] a,int m,int k,int mid){
        int c=0;
        int bouq=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=mid){
                c++;
            }else{
                bouq+=(c/k);
                c=0;
            }
        }
        bouq+=(c/k);
        return bouq>=m;
        // if(bouq==m) return true;
        // return false;
    }
}