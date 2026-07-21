//Typical bfs code for graph, the color must be similar in order to perform bfs.

class Solution {
    int[] row={1,0,-1,0};
    int[] col={0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] mat=image;
        int original=image[sr][sc];
        boolean[][] b=new boolean[image.length][image[0].length];
        dfs(image,sr,sc,color,original,b,mat);
        return mat;
    }
    private void dfs(int[][] image, int sr, int sc, int color,int original,boolean[][] b,int[][] mat){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || mat[sr][sc]!=original || b[sr][sc]) return;

        mat[sr][sc]=color;
        b[sr][sc]=true;
        for(int i=0;i<4;i++){
            dfs(image,sr+row[i],sc+col[i],color,original,b,mat);
        }
    }
}
