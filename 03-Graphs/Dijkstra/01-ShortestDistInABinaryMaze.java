//Basically a simple BFS just have a look on how the queue is created using the tuple class and the queue traversal syntax and distance checking.
class Tuple {
	int i;
	int j;
	int k;
	Tuple(int i, int j, int k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
}
class Solution {
	int[] row = {1, 0, -1, 0};
	int[] col = {0, 1, 0, -1};
	public int shortestPath(int[][] mat, int[] src, int[] dest) {
	  if(mat[src[0]][src[1]]==0 || mat[dest[0]][dest[1]]==0) return -1;
		Queue<Tuple> q = new LinkedList<>();
		int m = mat.length;
		int n = mat[0].length;
		int[][] dist = new int[m][n];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[src[0]][src[1]] = 0;
		q.add(new Tuple(0, src[0], src[1]));
		while (!q.isEmpty()) {
			Tuple t = q.poll();
			int x = t.i;
			int y = t.j;
			int z = t.k;
			if (y == dest[0] && z == dest[1])
				return x;
			for (int j = 0; j<4; j++) {
				int rr = y + row[j];
				int cc = z + col[j];
				if (rr >= 0 && cc >= 0 && rr<m && cc<n && mat[rr][cc] == 1 && x + 1<dist[rr][cc]) {
					dist[rr][cc] = x + 1;
					q.add(new Tuple(x + 1, rr, cc));
				}
			}
		}
		return - 1;
	}
}
