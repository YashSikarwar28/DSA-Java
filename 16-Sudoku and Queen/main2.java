//N-Knights

import java.util.ArrayList;
import java.util.Arrays;

public class main2 {
    public static void main(String[] args) {
        int n = 4;
        char[][] ch = new char[n][n];
        for (int i = 0; i < ch.length; i++) {
            Arrays.fill(ch[i], '.');
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        track(0, ch, n, ans);
        System.out.println(ans);
    }

    static void track(int row, char[][] ch, int n, ArrayList<ArrayList<String>> ans) {
        if (row == n) {
            ArrayList<String> main = new ArrayList<>();
            for (int i = 0; i < ch.length; i++) {
                main.add(new String(ch[i]));
            }
            ans.add(main);
            //System.out.println(ans);
            return;
        }
        int j = 0;
        while (j < n) {
            if (canPlaceKnight(row, j, ch, n)) {
                ch[row][j] = 'K';
                track(row + 1, ch, n, ans);
                ch[row][j] = '.';
            }
            j++;
        }
    }

    static boolean canPlaceKnight(int row, int col, char[][] ch, int n) {
        if (row-1>=0 && col-2>=0 && ch[row-1][col-2]=='K') {
            return false;
        }
        if (row-2>=0 && col-1>=0 && ch[row-2][col-1]=='K') {
            return false;
        }
        if(row-2>=0 && col+1<n && ch[row-2][col+1]=='K'){
            return false;
        }
        if (row-1>=0 && col+2<n && ch[row-1][col+2]=='K') {
            return false;
        }
        return true;
    }
}
