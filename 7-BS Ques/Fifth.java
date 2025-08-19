//Roated Binary Search

public class Fifth {
    static int search(int[]a,int tar){
        int pivot = findPivot(a);
        if (pivot==-1) {
            return binarySearch(a, tar, 0,a.length-1);
        }
        if (a[pivot]==tar) {
            return pivot;
        }
        else if(tar>a[0]){
            return binarySearch(a, tar, 0, pivot-1);
        }
        else{
            binarySearch(a, tar, pivot, a.length-1);
        }
        return binarySearch(a, tar, pivot+1, a.length-1);
    }

    static int binarySearch(int[] a,int target,int start,int end ){
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (target<a[mid]) {
                end=mid-1;
            }
            else if(target>a[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    static int findPivot(int[] a) {
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] < a[mid - 1]) {
                return mid - 1;
            } else if (a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[s] > a[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}


// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int s = 0;
//         int e = nums.length-1;
//         while (s<=e) {
//             int mid = s + (e-s)/2;
//             if (nums[mid]==nums[mid-1]) {
//                 e=mid-2;
//             }
//             else if(nums[mid]==nums[mid+1]){
//                 s=mid+2;
//             }
//             else{
//                 return mid;
//             }
//         }
//         return -1;
//     }
// }

// public class Fifth {

//     public static void main(String[] args) {
//         int[] nums = {1,1,2,3,3,4,4,8,8};
//          int s = 0;
//         int e = nums.length-1;
//         while (s<e) {
//             int mid = s + (e-s)/2;
//             if (nums[mid]==nums[mid-1]) {
//                 e=mid-2;
//             }
//             else if(nums[mid]==nums[mid+1]){
//                 s=mid+2;
//             }
//             else{
//                 System.out.println(mid);
//             }
//         }
//         //System.out.println(-1);
//     }
// }