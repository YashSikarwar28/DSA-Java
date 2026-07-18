class Solution {
    private void check(int node,boolean[] b,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> a){
        b[node]=true;
        a.add(node);
        for(int i:adj.get(node)){
            if(!b[i]){
                b[i]=true;
                check(i,b,adj,a);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] b=new boolean[adj.size()];
        b[0]=true;
        ArrayList<Integer> a=new ArrayList<>();
        check(0,b,adj,a);
        return a;
    }
}
