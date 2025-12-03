//Returning the list without passing it in the argument

import java.util.ArrayList;

public class Main4 {

    static ArrayList<Integer> list(int[] a,int i,int tar){
        ArrayList<Integer> a1=new ArrayList<>();

        if (i==a.length-1) {
            return a1;
        }
        if (a[i]==tar) {
            a1.add(i);
        }
        ArrayList<Integer> a2=list(a, i+1, tar);
        a1.addAll(a2);

        return a1;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,3,6,7};
        System.out.println(list(a, 0, 3));
    }
}
