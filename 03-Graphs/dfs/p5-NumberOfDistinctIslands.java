//Go to evry cell and check whether its 'L' or not and then start dfs take the original coordinates and then subtract them from the next 'L' coordinates which you will found through dfs add them in arraylist and then finally return the size of set.

class Solution {
    int[] row={1,0,-1,0};
    int[] col={0,1,0,-1};
    public int countDistinctIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        HashSet<ArrayList<Integer>> hs=new HashSet<>();
        boolean[][] b=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='L' && !b[i][j]){
                    ArrayList<Integer> a=new ArrayList<>();
                    dfs(grid,i,j,i,j,b,a);
                    hs.add(a);
                }
                else{
                    continue;
                }
            }
        }
        return hs.size();
    }
    private void dfs(char[][] grid,int oriR,int oriC,int i,int j,boolean[][] b,ArrayList<Integer> a){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='W' || b[i][j]) return;
        b[i][j]=true;
        int disti=i-oriR;
        int distj=j-oriC;
        a.add(disti);
        a.add(distj);
        for(int k=0;k<4;k++){
            int rr=i+row[k];
            int cc=j+col[k];
            dfs(grid,oriR,oriC,rr,cc,b,a);
        }
    }
}
