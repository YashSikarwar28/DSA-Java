//Concept similar to Ship Packages

class Solution {
    public int shipWithinDays(int[] a, int days) {
        int l=Arrays.stream(a).max().getAsInt();
        int h=Arrays.stream(a).sum();
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(check(a,mid,days)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] a,int mid,int days){
        int d=1;
        int sum=0;
        for(int i=0;i<a.length;i++){
            if(sum+a[i]<=mid){
            sum+=a[i];
            }
            else{
                d++;
                sum=a[i];
            }
        }
        return d<=days;
    }
}