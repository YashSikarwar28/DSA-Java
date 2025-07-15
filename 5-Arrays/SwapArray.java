//reverse all the array elements

import java.util.Arrays;

public class SwapArray {
    public static void main(String[] args) {
        int[] arr = {34,21,67,54,21,90,43};
         SwapArr(arr);
         System.out.println(Arrays.toString(arr));
    }

    static void SwapArr(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<end) {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

}
