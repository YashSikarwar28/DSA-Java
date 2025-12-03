//using ArrayList for searching and returning more than one occurences

import java.util.ArrayList;

public class Main3 {
    static ArrayList<Integer> same(int[] a,int i,ArrayList<Integer> al,int tar){
        if (i==a.length-1) {
            return al;
        }
        if(a[i]==tar){
            al.add(i);
        }
        return same(a, i+1, al, tar);
    }
    public static void main(String[] args) {
        int[] a={1,3,3,4,6,7,8};
        ArrayList<Integer> al=new ArrayList<>();
        System.out.println(same(a, 0, al, 3));
    }
}
