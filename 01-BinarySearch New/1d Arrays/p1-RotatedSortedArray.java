//check whether the array is right sorted or left sorted

class Solution {
    public int search(int[] a, int tar) {
        int s=0;
        int e=a.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(a[mid]==tar) return mid;
            //left part
            if(a[s]<=a[mid]){
                if(tar<=a[mid] && tar>=a[s]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
            //rght part
            else{
                if(tar>=a[mid] && tar<=a[e]){
                    s=mid+1;
                }else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }
}