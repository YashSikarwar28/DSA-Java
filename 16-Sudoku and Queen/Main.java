//N-Queens LC-51

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] ch=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(ch[i],'.');
        }
        List<List<String>> ans=new ArrayList<>();
        backtrack(ch,ans,n,0);
        return ans;
    }
    static void backtrack(char[][] ch,List<List<String>> ans,int n,int row){
        if(row==n){
            List<String> main=new ArrayList<>();
            for(int i=0;i<n;i++){
                  main.add(new String(ch[i])); 
                //main.add(Arrays.toString(ch[i]));
            }
            ans.add(main);
            return;
        }
        int col=0;
        while(col<n){
            if(canPlaceQueen(ch,n,row,col)){
                ch[row][col]='Q';
                backtrack(ch,ans,n,row+1);
                ch[row][col]='.';
            }
            col++;
        }
    }
    static boolean canPlaceQueen(char[][] ch,int n,int row,int col){
        int i=0;
        while(i<row){
            if(ch[i][col]=='Q'){
                return false;
            }
            i++;
        }
        i=row;
        int j=col;
        //left upper diagonal
        while(i>=0 && j>=0){
            if(ch[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row;
        j=col;
        //right upper diagonal
        while(i>=0 && j<n){
            if(ch[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}


// import java.util.ArrayList;
// import java.util.Arrays;

// public class Main {
//     public static void main(String[] args) {
//         int n = 4;
//         char[][] ch = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             Arrays.fill(ch[i], '.');
//         }
//         ArrayList<ArrayList<String>> board=new ArrayList<>();
//         backtrack(ch, 0, board, n);
//         System.out.println(board);
//     }
//     static void backtrack(char[][] ch, int row, ArrayList<ArrayList<String>> board, int n) {
//         if (row==n) {
//             ArrayList<String> arr=new ArrayList<>();
//             for(int i=0;i<n;i++){
//                 // System.out.println(Arrays.toString(ch[i]));
//                 //arr.add(Arrays.toString(ch[i]));
//                 arr.add(Arrays.toString(ch[i]));
//             }
//             board.add(arr);
//             return;
//         }
//         int col = 0;
//         while (col < n) {
//             if (canPlaceQueen(ch, row, col, n)) {
//                 ch[row][col] = 'Q';
//                 backtrack(ch, row + 1, board, n);
//                 ch[row][col] = '.';
//             }
//             col++;
//         }
//     }
//     static boolean canPlaceQueen(char[][] ch, int row, int col, int n) {
//         int i = 0;
//         while (i < row) {
//             if (ch[i][col] == 'Q') {
//                 return false;
//             }
//             i++;
//         }
//         i = row;
//         int j = col;
//         while (i >= 0 && j >= 0) {
//             if (ch[i][j] == 'Q') {
//                 return false;
//             }
//             i--;
//             j--;
//         }
//         i = row;
//         j = col;
//         while (i >= 0 && j < n) {
//             if (ch[i][j] == 'Q') {
//                 return false;
//             }
//             i--;
//             j++;
//         }
//         return true;
//     }
// }
