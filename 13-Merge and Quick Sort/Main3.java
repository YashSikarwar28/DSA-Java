//Quick Sort(not stable)

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        int[] a={2,5,1,4,9,6,7};
        quick(a, 0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    static void quick(int[] a,int low,int high){
        if (low>=high) {
            return;
        }
        int s=low;
        int e=high;
        int mid=s+(e-s)/2;
        int pivot=a[mid];
        while (s<=e) {
            while (a[s]<pivot) {
                s++;
            }   
            while (a[e]>pivot) {
                e--;
            }
            if (s<=e) {
                int temp=a[s];
                a[s]=a[e];
                a[e]=temp;
                s++;
                e--;
            }
        }
        quick(a, low, e);
        quick(a, s, high);
    }
}