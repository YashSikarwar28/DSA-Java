//Use bfs the only codition is if the next element is already visited like parent!=ind then true.
class Pair{
    int num;
    int ind;
    Pair(int num,int ind){
        this.num=num;
        this.ind=ind;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<V;i++){
            a.add(new ArrayList<>());
        }
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            a.get(u).add(v);
            a.get(v).add(u);
        }
        boolean[] b=new boolean[V];
        for(int i=0;i<V;i++){
            if(!b[i]){
                if(bfs(b,i,a)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bfs(boolean[] b,int i,ArrayList<ArrayList<Integer>> a){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,-1));
        b[i]=true;
        while(!q.isEmpty()){
            Pair pp=q.poll();
            int num = pp.num;
            int ind = pp.ind;
            for(int j:a.get(num)){
                if(!b[j]){
                    b[j]=true;
                    q.add(new Pair(j,num));
                }else if(j!=ind){
                    return true;
                }
            }
        }
        return false;
    }
}
