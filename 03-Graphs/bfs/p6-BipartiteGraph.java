//Bipartite mean that each node can be coloured with different colour. Simply travers in the graph given and fill tha array with -1 value as default then use BFS traverse through the graph and check whether the node is coloured or not, if not coloured fill accordingly otherwise if the color is same return false.

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
            if(!bfs(graph,i,color)){
                return false;
            }
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph,int i,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int j:graph[node]){
                if(color[j]==-1){
                    color[j]=color[node]==0?1:0;
                    q.add(j);
                }
                else if(color[j]==color[node]) return false;
            }
        }
        return true;
    }
}
