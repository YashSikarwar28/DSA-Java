//Similar to book allocation

class Solution {
    public int minTime(int[] a, int k) {
        if(a.length<k) return -1;
        int l=Arrays.stream(a).max().getAsInt();
        int h=Arrays.stream(a).sum();
        while(l<=h){
            int mid=l+(h-l)/2;
            if(check(a,k,mid)){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private boolean check(int[] a,int k,int mid){
        int painter=1;
        int dist=0;
        for(int i=0;i<a.length;i++){
            if(dist+a[i]<=mid){
                dist+=a[i];
            }else{
                dist=a[i];
                painter++;
            }
        }
        return painter<=k;
    }
}
