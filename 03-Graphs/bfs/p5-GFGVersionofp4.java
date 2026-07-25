//Same as p4 only difference is here we are using arraylist.

class Pair{
    int row;
    int col;
    int steps;
    Pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] b=new boolean[m][n];
        for(int i=0;i<m;i++){
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<n;j++){
                a.add(0);
            }
            ans.add(a);
        }
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    b[i][j]=true;
                }else{
                    b[i][j]=false;
                }
            }
        }
        int[] r={1,0,-1,0};
        int[] c={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int rr=p.row;
            int cc=p.col;
            int ss=p.steps;
            ans.get(rr).set(cc,ss);
            for(int i=0;i<4;i++){
                int r1=rr+r[i];
                int c1=cc+c[i];
                if(r1>=0 && c1>=0 && r1<m && c1<n && !b[r1][c1]){
                    b[r1][c1]=true;
                    q.add(new Pair(r1,c1,ss+1));
                }
            }
        }
        return ans;
    }
}
