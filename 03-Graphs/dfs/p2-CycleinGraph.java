class Solution {

    boolean cycle=false;

    public boolean isCycle(int v, int[][] edges) {

        List<List<Integer>> l=new ArrayList<>();

        for(int i=0;i<v;i++){

            l.add(new ArrayList<>());

        }

        for(int i=0;i<edges.length;i++){

            int src=edges[i][0];

            int dest=edges[i][1];

            l.get(src).add(dest);

            l.get(dest).add(src);

        }

        boolean[] b=new boolean[v];
        for(int i=0;i<v;i++){
            if(!b[i]){
                dfs(l,b,-1,i);
                //-1 for parent initially
            }

        }
        return cycle;
    }

    private void dfs(List<List<Integer>> l,boolean[] b,int parent,int i){

        b[i]=true;

        for(int j:l.get(i)){

            //visited and parent is not equal to children that means cycle is present

            if(b[j] && j!=parent){

                cycle=true;

                return;

            }

            if(!b[j]){

                dfs(l,b,i,j);

            }

        }

        return;

    }

}
