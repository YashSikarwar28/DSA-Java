//duplicates present just one extra condition rest everything is same

class Solution {
    public boolean search(int[] a, int tar) {
        int low=0;
        int high=a.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]==tar) return true;
            if(a[low]==a[mid] && a[mid]==a[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            if(a[low]<=a[mid]){
                if(a[low]<=tar && tar<=a[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            else{
                if(a[mid]<=tar && tar<=a[high]){
                    low=low+1;
                }else{
                    high=high-1;
                }
            }
        }
        return false;
    }
}