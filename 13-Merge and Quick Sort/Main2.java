//Merge Sort

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] a={4,2,6,2,6,1,8,5,9};
        System.out.println(Arrays.toString(merge(a)));
    }
    static int[] merge(int[] a){
          if (a.length==1) {
            return a;
        }
        int mid=a.length/2;
        int[] left=merge(Arrays.copyOfRange(a,0,mid));
        int[] right=merge(Arrays.copyOfRange(a,mid,a.length));

        return mergeArrays(left,right);
    }
    static int[] mergeArrays(int[] left,int[] right){
        int i=0;
        int j=0;
        int k=0;
        int[] arr=new int[right.length+left.length];
        while (i<left.length && j<right.length) {
            if (left[i]<right[j]) {
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while (i<left.length) {
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j<right.length) {
            arr[k]=right[j];
            j++;
            k++;
        }
        return arr;
    }
}