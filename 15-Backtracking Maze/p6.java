//Printing the number of steps and path required to reach our destination using Backtracking

import java.util.Arrays;

public class p6 {
    public static void main(String[] args) {
        boolean[][] maze={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int[][] path=new int[maze.length][maze[0].length];
        allPathPrint("", 0, 0, maze,path , 1);
    }
    static void allPathPrint(String p,int r,int c,boolean[][] maze,int[][] path,int count){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=count;
            for(int[] arr:path){
                System.out.println(Arrays.toString(arr));
            }
            //System.out.println(count);
            System.out.println(p);
        }
        if (!maze[r][c]) {
            return;
        }
        maze[r][c]=false;
        path[r][c]=count;
        if (r<maze.length-1) {
            allPathPrint(p+"D", r+1, c, maze, path, count+1);
        }
        if (c<maze[0].length-1) {
            allPathPrint(p+"R", r, c+1, maze, path, count+1);
        }
        if (r>0) {
            allPathPrint(p, r-1, c, maze, path, count+1);
        }
        if (c>0) {
            allPathPrint(p, r, c-1, maze, path, count+1);
        }
        maze[r][c]=true;
        path[r][c]=0;
    }
}