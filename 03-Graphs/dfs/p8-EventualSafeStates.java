//Similar to previous question just in this question we have to maintain one more array for marking all the safe nodes and in this we will not stop the dfs once we find the cycle like we did in previous question we will continue the dfs for all the node in the graph. In the end once the dfs is over we will loop through the safenode array and if it true we will add it in the list.
//A node is safe if it ends to a terminal node

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] path=new boolean[graph.length];
        boolean[] visited=new boolean[graph.length];
        boolean[] checkNode=new boolean[graph.length];
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                l.get(i).add(graph[i][j]);
            }
        }
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfs(l,i,path,visited,checkNode);
            }
        }
        for(int i=0;i<graph.length;i++){
            if(checkNode[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfs(List<List<Integer>> l,int i,boolean[] path,boolean[] visited,boolean[] checkNode){
        path[i]=true;
        visited[i]=true;
        checkNode[i]=false;
        for(int j:l.get(i)){
            if(!visited[j]){
                if(dfs(l,j,path,visited,checkNode)){
                    return true;
                }
            }
            if(path[j]){
                return true;
            }
        }
        path[i]=false;
        checkNode[i]=true;
        return false;
    }
}
