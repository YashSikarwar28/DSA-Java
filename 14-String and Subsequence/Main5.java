//Permutation Subsequence

// public class Main5 {
//     public static void main(String[] args) {
//         permu("", "abc");
//     }
//     static void permu(String a,String b){
//         if (b.isEmpty()) {
//             System.out.println(a);
//             return;
//         }
//         char ch=b.charAt(0);
//         for(int i=0;i<=a.length();i++){
//             String first=a.substring(0,i);
//             String second=a.substring(i,a.length());
//             permu(first+ch+second, b.substring(1));
//         }
//     }
// }

import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) {
        System.out.println(permu("", "abcd"));
    }

    static ArrayList<String> permu(String a, String b) {
        if (b.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(a);
            return ans;
        }
        char ch = b.charAt(0);
        ArrayList<String> main = new ArrayList<>();
        for (int i = 0; i <= a.length(); i++) {
            String first = a.substring(0, i);
            String second = a.substring(i, a.length());
            main.addAll(permu(first + ch + second, b.substring(1)));
        }
        return main;
    }
}