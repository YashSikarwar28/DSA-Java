//Similar to median only change is in low and high value observe that carefully.

class Solution {
    public int kthElement(int a[], int b[], int k) {
        if(a.length>b.length){
            return kthElement(b,a,k);
        }
        int m=a.length;
        int n=b.length;
        int l=Math.max(0,k-n);
        int h=Math.min(m,k);
        while(l<=h){
            int x=l+(h-l)/2;
            //int y=(m+n+1)/2-x;
            int y=k-x;
            
            int x1=(x==0)?Integer.MIN_VALUE:a[x-1];
            int x2=(y==0)?Integer.MIN_VALUE:b[y-1];
            
            int x3=(x==m)?Integer.MAX_VALUE:a[x];
            int x4=(y==n)?Integer.MAX_VALUE:b[y];
            
            if(x1<=x4 && x2<=x3){
                return Math.max(x1,x2);
            }
            if(x1>x4){
                h=x-1;
            }else{
                l=x+1;
            }
        }
        return -1;
    }
}