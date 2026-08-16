//Similar to Kahns algo we just need an ans array to print the values.
class Solution {
    public int[] findOrder(int n, int[][] p) {
        int m=p.length;
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            l.get(p[i][0]).add(p[i][1]);
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j:l.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[n];
      //the array value will come in reverse thats why adding the value from end to get the correct output
        int k=n-1;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[k--]=node;
            for(int i:l.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(k!=-1){
            return new int[0];
        }
        return ans;
    }
}
