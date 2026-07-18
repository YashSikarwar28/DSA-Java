//take a visited array, an arraylist and queue.
class Solution {
	public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
	    ArrayList<Integer> res=new ArrayList<>();
	    boolean[] b=new boolean[adj.size()];
	    b[0]=true;
	    Queue<Integer> q=new LinkedList<>();
	    q.add(0);
	    while(!q.isEmpty()){
	        int t=q.poll();
	        res.add(t);
	        for(int i:adj.get(t)){
	            if(!b[i]){
	                b[i]=true;
	                q.add(i);
	            }
	        }
	    }
	    return res;
	}
}
