//using ArrayList to print the path

import java.util.ArrayList;

public class p2 {
    public static void main(String[] args) {
        System.out.println(path("", 3, 3));
    }
    static ArrayList<String> path(String s,int r,int c){
        if (r==1 && c==1) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(s);
            return ans;
        }
        ArrayList<String> ans=new ArrayList<>();
        if (r>1) {
            ans.addAll(path(s+"R", r-1, c));
        }
        if (c>1) {
            ans.addAll(path(s+"D", r, c-1));
        }
        return ans;
    }
}



// import java.util.ArrayList;

// public class p2 {
//     public static void main(String[] args) {
//         ArrayList<ArrayList<String>> ans=new ArrayList<>();
//         path(3, 3, ans, new ArrayList<>());
//         System.out.println(ans);
//     }
//     static void path(int r,int c,ArrayList<ArrayList<String>> ans,ArrayList<String> ds){
//         if (r==1 && c==1) {
//             ans.add(new ArrayList<>(ds));
//             return;
//         }
//         if (r>1) {
//             ds.add("R");
//             path(r-1, c, ans, ds);
//         }
//         if (c>1) {
//             ds.add("D");
//             path(r, c-1, ans, ds);
//         }
//     }
// }