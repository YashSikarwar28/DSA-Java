//Convert matrix into adjacency list, create boolean for marking visited and then apply dfs.

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n=isConnected.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    l.get(i).add(j);
                }
            }
        }
        boolean[] b=new boolean[n];
        for(int i=0;i<n;i++){
            if(!b[i]){
                dfs(b,i,l);
                count++;
            }
        }
        return count;
    }
    private void dfs(boolean[] b,int i,List<List<Integer>> l){
        b[i]=true;
        for(int j:l.get(i)){
            if(!b[j]){
                b[j]=true;
                dfs(b,j,l);
            }
        }
    }
}
