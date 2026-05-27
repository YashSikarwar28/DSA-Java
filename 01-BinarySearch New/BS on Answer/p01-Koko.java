class Solution {
    public int minEatingSpeed(int[] a, int h) {
        int l=1;
        int b=Arrays.stream(a).max().getAsInt();
        int ans=0;
        while(l<=b){
            int mid=l+(b-l)/2;
            int c=check(a,mid);
            if(c<=h){
                b=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private int check(int[] a,int mid){
        int ans=0;
        for(int i=0;i<a.length;i++){
            ans+=Math.ceil((double)a[i]/mid);
        }
        return ans;
    }
}