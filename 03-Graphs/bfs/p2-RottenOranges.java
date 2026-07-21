//Create a new matrix according to original count the rotten ones and push in queue then apply bfs and count that the original must be equal to rotten in end.

class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] mat=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    mat[i][j]=2;
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==1){
                    mat[i][j]=1;
                    fresh++;
                }else{
                    mat[i][j]=0;
                }
            }
        }
        int rotten=0;
        int time=0;
        int[] row={1,0,-1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty()){
                Pair p=q.poll();
                int r=p.row;
                int c=p.col;
                int t=p.time;
                time=Math.max(time,t);
                for(int i=0;i<4;i++){
                    int nr=r+row[i];
                    int nc=c+col[i];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc]==1){
                        q.add(new Pair(nr,nc,t+1));
                        mat[nr][nc]=2;
                        rotten++;
                    }
                }
        }
        if(rotten!=fresh) return -1;
        return time;
    }
}
