//Similar syntax only just take a note of the dividing part. 

class Solution {
    public int minimumSize(int[] a, int op) {
        int l=1;
        int h=Arrays.stream(a).max().getAsInt();
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(check(a,op,mid)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] a,int op,int mid){
        long c=0;
        for(int i=0;i<a.length;i++){
            c+=a[i]/mid;
            if(a[i]%mid==0){
                c=c-1;
            }
        }
        return c<=op;
    }
}
