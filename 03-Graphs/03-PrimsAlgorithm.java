//Used to find Minimum Spanning Tree/weight in a graph.
//Main thing is here we will keep a visited boolean array to track whether the nodes are seen or not.
class Pair {
	int node;
	int dist;
	Pair(int node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}
class PQ {
	int dist;
	int node;
	PQ(int dist, int node) {
		this.dist = dist;
		this.node = node;
	}
}
class Solution {
	public int spanningTree(int V, int[][] edges) {
		ArrayList<ArrayList<Pair>> al = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			al.add(new ArrayList<>());
		}
		for (int i = 0; i<edges.length; i++) {
			al.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
			al.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
		}
		PriorityQueue<PQ> pq = new PriorityQueue<>((a, b)->Integer.compare(a.dist, b.dist));
		pq.add(new PQ(0, 0));
		boolean[] visited = new boolean[V];
		int sum = 0;
		while (!pq.isEmpty()) {
			PQ p = pq.poll();
			int n = p.node;
			int d = p.dist;
			if (visited[n])
				continue;
			visited[n] = true;
			sum += d;
			for (Pair pp:al.get(n)) {
				int n2 = pp.node;
				int d2 = pp.dist;
				if (!visited[n2]) {
					pq.add(new PQ(d2, n2));
				}
			}
		}
		return sum;
	}
}
