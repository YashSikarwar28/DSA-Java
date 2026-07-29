//Similar to typical dfs questions just add sutable conditions check.
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(!dfs(graph,color,i)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] color,int i){
        for(int j:graph[i]){
            if(color[j]==-1){
                color[j]=(color[i]==1)?0:1;
                //color[j]=1-color[i];
                if(!dfs(graph,color,j)){
                    return false;
                }
            }
            else if(color[i]==color[j]) return false;
        }
        return true;
    }
}
