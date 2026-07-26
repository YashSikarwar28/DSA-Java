//Similar to p3 just add a counter and keep updating it.

class Solution {
    int count;
    int[] row={1,0,-1,0};
    int[] col={0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        count=0;
        int[][] temp=grid;
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] b=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(i==0 || i==m-1){
                for(int j=0;j<n;j++){
                    dfs(temp,i,j,b);
                }
            }
            else{
                for(int j=0;j<n;j++){
                    if(j==0 || j==n-1){
                        dfs(temp,i,j,b);
                    }else{
                        continue;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]==1 && !b[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] temp,int i,int j,boolean[][] b){
        if(i<0 || j<0 || i>=temp.length || j>=temp[0].length || b[i][j] || temp[i][j]==0) return;
        b[i][j]=true;
        for(int k=0;k<4;k++){
            int rr=i+row[k];
            int cc=j+col[k];
            dfs(temp,rr,cc,b);
        }
    }
}
