//Concept is similar to KOKO

class Solution {
    public int smallestDivisor(int[] a, int threshold) {
        int l=1;
        int h=Arrays.stream(a).max().getAsInt();
        int div=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            int ans=check(a,threshold,mid);
            if(ans>threshold){
                l=mid+1;
            }else{
                div=mid;
                h=mid-1;
            }
        }
        return div;
    }
    private int check(int[] a,int threshold,int mid){
        int s=0;
        for(int i=0;i<a.length;i++){
            //s+=Math.ceil((double)a[i]/mid);
            s+=(a[i]+mid-1)/mid;
        }
        return s;
    }
}