//When the graph is changing dynamically, adding or updating after each step think of disjoint
//Main thing is we are converting 2d arr indices into 1d length would be m*n and for accesing a particular index we will use the formula i*col+row.
//Type of dfs traversal going through the nodes, main thing is if a particular node is alreay connected or is having a super parent we will decrease the count.
class DisjointSet {
	List<Integer> parent = new ArrayList<>();
	List<Integer> rank = new ArrayList<>();
	public DisjointSet(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			parent.add(i);
		}
	}
	public int findUltimateParent(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int ulp = findUltimateParent(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}
	public void UnionByRank(int u, int v) {
		int ulp_u = findUltimateParent(u);
		int ulp_v = findUltimateParent(v);
		if (ulp_u == ulp_v)
			return;
		if (rank.get(ulp_u)<rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		} else if (rank.get(ulp_v)<rank.get(ulp_u)) {
			parent.set(ulp_v, ulp_u);
		}
		else {
			// both equal connect anyone
			parent.set(ulp_u, ulp_v);
			int r = rank.get(ulp_v);
			rank.set(ulp_v, r + 1);
		}
	}
}
class Solution {
	public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
		DisjointSet dsu = new DisjointSet(m*n);
		int[][] arr = new int[n][m];
		int c = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i<operators.length; i++) {
			int u = operators[i][0];
			int v = operators[i][1];
			if (arr[u][v] == 1) {
				ans.add(c);
				continue;
			}
			arr[u][v] = 1;
			c++;
			int[] row = {1, 0, -1, 0};
			int[] col = {0, 1, 0, -1};
			for (int j = 0; j<4; j++) {
				int nr = u + row[j];
				int nc = v + col[j];
				if (nr >= 0 && nc >= 0 && nr<n && nc<m && arr[nr][nc] == 1) {
					int originall = u*m + v;
					int neww = nr*m + nc;
					if (dsu.findUltimateParent(originall) != dsu.findUltimateParent(neww)) {
						c--;
						dsu.UnionByRank(originall, neww);
					}
				}
			}
			ans.add(c);
		}
		return ans;
	}
}
