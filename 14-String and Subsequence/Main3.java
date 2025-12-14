//Subsequence question - string

import java.util.ArrayList;

public class Main3 {
    //private static ArrayList<String> s;
    public static void main(String[] args) {
        subseq("", "abcde");
    }
    static void subseq(String a,String b){
        if (b.isEmpty()) {
            //s.add(a);
            //System.out.println(s);
            System.out.println(a);
            return;
        }
        char ch=b.charAt(0);

        subseq(a+ch,b.substring(1));
        subseq(a,b.substring(1));
    }
}