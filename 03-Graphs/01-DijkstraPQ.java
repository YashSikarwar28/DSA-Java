//Stores the shorted path starting from source node in an undirected graph with positve distance
//Similar to bfs and topo sort in DAG 
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        ArrayList<Integer> dist=new ArrayList<>();
        for(int i=0;i<V;i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(src,0);
        //Default syntax for Priority Queue for getting the minimum element at the top of queue.
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Integer.compare(a.dist,b.dist));
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int n=p.node;
            int d=p.dist;
            //if the distance is bigger no need to process it 
            if(d>dist.get(n)) continue;
            for(Pair nn:adj.get(n)){
                int weig=nn.dist;
                int nextNode=nn.node;
                if(d+weig<dist.get(nextNode)){
                    dist.set(nextNode,d+weig);
                    pq.add(new Pair(nextNode,d+weig));
                }
            }
        }
        return dist;
    }
}
