class Solution {
    public int findPages(int[] a, int k) {
        if(a.length<k) return -1;
        int l=Arrays.stream(a).max().getAsInt();
        int h=Arrays.stream(a).sum();
        int ans=0;
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
        int books=1;
        int pages=0;
        for(int i=0;i<a.length;i++){
            if(pages+a[i]<=mid){
                pages+=a[i];
            }else{
                books++;
                pages=a[i];
            }
        }
        return books<=k;
    }
}