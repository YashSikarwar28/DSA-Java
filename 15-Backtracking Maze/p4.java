//Maze with obstacle

public class p4 {
    public static void main(String[] args) {
        boolean[][] ans={
            {true,true,true},
            {true,false,true},
            {true,true,true},
        };
        obs("", ans, 0, 0);
    }
    static void obs(String s,boolean[][] ans,int r,int c){
        if (r==ans.length-1 && c==ans[0].length-1) {
            System.out.println(s);
            return;
        }
        if (!ans[r][c]) {
            return;
        }
        if (r<ans.length-1) {
            obs(s+"R", ans, r+1, c);
        }
        if (c<ans[0].length-1) {
            obs(s+"C", ans, r, c+1);
        }
    }
}