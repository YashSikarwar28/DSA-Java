//We will only traverse the corners of matrix and if 'O' is present we will start dfs from that 'O' and connect all 'O' and mark true, then we will run loop again and all those which are false and are 'O' we will convert them into 'X'.

class Solution {
    int[] row={1,0,-1,0};
    int[] col={0,1,0,-1};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] b=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(i==0 || i==m-1){
                for(int j=0;j<n;j++){
                    if(board[i][j]=='O'){
                        dfs(board,i,j,b);
                    }
                }
            }
            else if(i!=0 && i!=m-1){
                for(int j=0;j<n;j++){
                    if(j!=0 && j!=n-1) continue;
                    else{
                        if(board[i][j]=='O' && !b[i][j]){
                            dfs(board,i,j,b);
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !b[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j,boolean[][] b){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || b[i][j] || board[i][j]=='X') return;
        b[i][j]=true;
        for(int k=0;k<4;k++){
            int rr=i+row[k];
            int cc=j+col[k];
            dfs(board,rr,cc,b);
            // if(board[rr][cc]=='O'){
            //     board[rr][cc]='s';
            //     dfs(board,rr,cc,b);
            // }
        }
    }
}
