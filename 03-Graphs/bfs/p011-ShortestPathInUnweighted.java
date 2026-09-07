//Its like typical bfs algo just we have to put a check for handling shortest distance and updating the value accordingly. 
class Solution {
	public int shortestPath(int v, int[][] edges, int src, int dest) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i<v; i++) {
			arr.add(new ArrayList<>());
		}
		for (int i = 0; i<edges.length; i++) {
			arr.get(edges[i][0]).add(edges[i][1]);
			arr.get(edges[i][1]).add(edges[i][0]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		int[] ans = new int[v];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[src] = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			for (int j:arr.get(n)) {
        //shortest distance check
				if (ans[n]+1<ans[j]) {
					ans[j] = ans[n]+1;
					q.add(j);
				}
			}
			if (n == dest) {
				return ans[n];
			}
		}
		return - 1;
	}
}
