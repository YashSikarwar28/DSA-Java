//ceiling and floor of a number in an array


// public class First {
//     public static void main(String[] args) {
//         int []arr = {2,3,5,9,14,16,18};
//         int tar = 6;
//         System.out.println(ceiling(arr, tar));
//     }
//     static int ceiling(int[] arr,int tar){
//         int start=0;
//         int end = arr.length - 1;
//         while (start<=end) {
//             int mid  = start + (end-start)/2;
//             if (tar<arr[mid]) {
//                 end=mid-1;
//             }
//             else if(tar>arr[mid]){
//                 start=mid+1;
//             }
//             else{
//                 return mid;
//             }
//         }
//         return start;
//     }
// }


public class First {

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,9,14,18};
        int tar = 15;
        System.out.println(floor(arr, tar));
    }
    static int floor(int[] arr,int tar){
        int start = 0;
        int end = arr.length - 1;
        while (start<=end) {
            int mid = start + (end-start)/2;
            if (tar<arr[mid]) {
                end=mid-1;
            }
            else if(tar>arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return end;
    }
}