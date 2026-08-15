//create the indegree array then the node with 0 indegree insert it in queue then use bfs algo till the queue is not empty and while looping in bfs do indegree-- of that particular node and if 0 insert it in queue.

class Solution {
    public ArrayList<Integer> topoSort(int v, int[][] edges) {
        ArrayList<Integer> ans=new ArrayList<>();
        int[] indegree=new int[v];
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<v;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            l.get(edges[i][0]).add(edges[i][1]);
        }
      //creating the indegree array
        for(int i=0;i<v;i++){
            for(int j:l.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i:l.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
