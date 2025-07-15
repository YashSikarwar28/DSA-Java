//using functions

import java.util.Arrays;

public class UsingFunctions {
    public static void main(String[] args) {
        int[] a = {3,4,5,6,7};
        System.out.println(Arrays.toString(a));
        change(a);
        System.out.println(Arrays.toString(a));
    }
    static void change(int[] a){
        a[0]=99;
    }
}
