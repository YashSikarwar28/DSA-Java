//Now we can go diagonally

import java.util.ArrayList;

public class p3 {
    public static void main(String[] args) {
        System.out.println(diagonally("", 3, 3));
    }
    static ArrayList<String> diagonally(String s,int r,int c){
        if (r==1 && c==1) {
            ArrayList<String> ans=new ArrayList<>();
            ans.add(s);
            return ans;
        }
        ArrayList<String> ans=new ArrayList<>();
        //diagonal condition
        if (r>1 && c>1) {
            ans.addAll(diagonally(s+"D", r-1, c-1));
        }
        if (r>1) {
            ans.addAll(diagonally(s+"R", r-1, c));
        }
        if (c>1) {
            ans.addAll(diagonally(s+"C", r, c-1));
        }
        return ans;
    }
}
