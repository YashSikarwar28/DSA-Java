//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
//Use the normal dfs format just at the end of dfs add the element into the stack.

class Solution {
    public ArrayList<Integer> topoSort(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        boolean[] visited=new boolean[v];
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            arr.get(edge[0]).add(edge[1]);
        }
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(visited,i,arr,st);
            }
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    private void dfs(boolean[] visited,int i,ArrayList<ArrayList<Integer>> arr,Stack<Integer> st){
        visited[i]=true;
        for(int j:arr.get(i)){
            if(!visited[j]){
                dfs(visited,j,arr,st);
            }
        }
        st.add(i);
    }
}
