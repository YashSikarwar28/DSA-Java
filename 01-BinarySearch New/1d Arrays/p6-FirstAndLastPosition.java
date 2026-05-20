//make 2 seperate functions and check the first value from l to mid and second value from md to high

class Solution {
    public int[] searchRange(int[] a, int tar) {
        int c=first(a,tar);
        int d=second(a,tar);
        return new int[]{c,d};
    }
    private int first(int[] a,int tar){
        int l=0;
        int h=a.length-1;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==tar){
                ans=mid;
                h=mid-1;
            }
            if(a[mid]<tar){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
    private int second(int[] a,int tar){
        int l=0;
        int h=a.length-1;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==tar){
                ans=mid;
                l=mid+1;
            }else if(a[mid]<tar){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
}