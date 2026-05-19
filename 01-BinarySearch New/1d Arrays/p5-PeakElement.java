//check adjacent value and then predict whether it is decreasing or increasing, some part of the array is sorted

class Solution {
    public int findPeakElement(int[] a) {
        if(a.length==1) return 0;
        int l=1;
        int h=a.length-2;
        if(a[0]>a[1]) return 0;
        if(a[a.length-1]>a[a.length-2]) return a.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]>a[mid-1] && a[mid]>a[mid+1]) return mid;
            if(a[mid]<a[mid-1]){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}