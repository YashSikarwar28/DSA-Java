//LeetCode - 77 Combinations Backtracking

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n=1;
        int k=1;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> main=new ArrayList<>();
        combi(n, k, ans, main, 1);
    }    
    static void combi(int n,int k,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> main,int ind){
        if (k==0) {
            ans.add(new ArrayList<>(main));
            System.out.println(ans);
            return;
        }
        for(int i=ind;i<=n;i++){
            main.add(i);
            combi(n, k-1, ans, main, i+1);
            main.remove(main.size()-1);
        }
    }
}
