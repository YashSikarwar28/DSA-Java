//swap values in array using function

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 2, 1, 7 };
        swap(arr, 2, 5);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int in1, int in2) {
        int temp = arr[in1];
        arr[in1] = arr[in2];
        arr[in2] = temp;
    }
}
