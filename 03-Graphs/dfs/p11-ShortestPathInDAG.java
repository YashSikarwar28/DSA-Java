//Create a pair class for storing the node and distance.
//Then create the graph have a good look the syntax.
//Then apply toposort and store the answer in stack
//Then create ans arraylist for storing the answer, while the stack is not empty get the value ans use that value to loop in graph and check the distance if distance is smaller update it.
//In the end if any value is not updated and is max_value assign -1 to it.
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public ArrayList<Integer> shortestPath(int v, int[][] edges) {
        ArrayList<ArrayList<Pair>> arr=new ArrayList<>();
        for(int i=0;i<v;i++){
             ArrayList<Pair> temp=new ArrayList<>();
             arr.add(temp);
        }
        for(int i=0;i<edges.length;i++){
            int n=edges[i][1];
            int d=edges[i][2];
            arr.get(edges[i][0]).add(new Pair(n,d));
        }
        boolean[] visited=new boolean[v];
        Stack<Integer> st=new Stack();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                topo(arr,i,visited,st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<v;i++){
            ans.add(Integer.MAX_VALUE);
        }
      //starting node so initially marked as zero because distance to itslef is zero.
        ans.set(0,0);
        while(!st.isEmpty()){
            int ind=st.pop();
            if(ans.get(ind)==Integer.MAX_VALUE){
                continue;
            }
            for(int i=0;i<arr.get(ind).size();i++){
                Pair p=arr.get(ind).get(i);
                int d=p.dist;
                int n=p.node;
                if(ans.get(ind)+d<ans.get(n)){
                    ans.set(n,ans.get(ind)+d);
                }
            }
        }
        for(int i=0;i<ans.size();i++){
            if(ans.get(i)==Integer.MAX_VALUE){
                ans.set(i,-1);
            }
        }
        return ans;
    }
    private void topo(ArrayList<ArrayList<Pair>> arr,int i,boolean[] visited,Stack<Integer> st){
        visited[i]=true;
        for(int j=0;j<arr.get(i).size();j++){
            int v=arr.get(i).get(j).node;
            if(!visited[v]){
                topo(arr,v,visited,st);
            }
        }
        st.add(i);
    }
}
