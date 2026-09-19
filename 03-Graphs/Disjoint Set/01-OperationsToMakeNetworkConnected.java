//Disjoint Set code is same, for this question if the parent is same then we increase the nodes count and then we loop on parent array if the node is super parent we increase the count, because we want the minimum so if the count exceeds we will return the minimum
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findUltimate(int node) {
        if (node == parent.get(node))
            return node;
        int ulp = findUltimate(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUltimate(u);
        int ulp_v = findUltimate(v);
        if (ulp_u == ulp_v)
            return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_u, ulp_v);
            int r = rank.get(ulp_v);
            rank.set(ulp_v, r + 1);
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            //if equal increse the count
            if (ds.findUltimate(u) == ds.findUltimate(v)) {
                extra++;
            } else {
                ds.unionByRank(u, v);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                count++;
            }
        }
        int ans = count - 1;
        //if extra return minimum
        if (extra >= ans)
            return ans;
        return -1;
    }
}
