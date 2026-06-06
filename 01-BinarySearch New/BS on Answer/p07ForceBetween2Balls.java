//Same as agressive cows

class Solution {
    public int maxDistance(int[] a, int m) {
        Arrays.sort(a);
        int l=1;
        int h=a[a.length-1]-a[0];
        while(l<=h){
            int mid=l+(h-l)/2;
            if(place(a,m,mid)){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return h;
    }
    private boolean place(int[] a,int m,int mid){
        int ball=1;
        int dist=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]-dist>=mid){
                ball++;
                dist=a[i];
            }
            if(ball>=m) return true;
        }
        return false;
    }
}