//We will take 2 boolean arrays one for path and the other one for visited, if a node is visited it will remain true throughout the dfs but the path node will be set to false at the end of function call and for checking dfs we will check whether the path is already explored or not.

class Solution {
    public boolean isCyclic(int v, int[][] edges) {
        boolean[] visited=new boolean[v];
        boolean[] path=new boolean[v];
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<v;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            l.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(check(l,i,visited,path)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(List<List<Integer>> l,int i,boolean[] visited,boolean[] path){
        visited[i]=true;
        path[i]=true;
        for(int j:l.get(i)){
            if(!visited[j]){
                if(check(l,j,visited,path)){
                    return true;
                }
            }
            else if(path[j]){
                return true;
            }
        }
        path[i]=false;
        return false;
    }
}
