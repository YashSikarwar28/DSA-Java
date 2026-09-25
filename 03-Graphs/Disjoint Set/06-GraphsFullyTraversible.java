//We will make 2 DSU for alice and bob and while traversing we will give priority to type 3 path because it can be travelled by both thats why we will sort the input in descending order and then apply the DSU.
//While connecting we will increase the count and we will also initialize a component variable with size n and we will decreace the component size by one in DSU call  and while connecting we will increase the path by one.
//The main thing in this question is the 2 seperate DSU call for alice and bob so look at that carefully and the sorting part is also new so look at that as well.
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    int components;

    public DisjointSet(int n) {
        components = n;
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
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            //both equal connect anyone
            parent.set(ulp_u, ulp_v);
            int r = rank.get(ulp_v);
            rank.set(ulp_v, r + 1);
        }
        components--;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //Sorting in decending order
        Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);
        int count = 0;
        for (int[] ed : edges) {
            int type = ed[0];
            int u = ed[1];
            int v = ed[2];
            if (type == 3) {
                boolean add = false;
                if (alice.findUltimateParent(u) != alice.findUltimateParent(v)) {
                    alice.UnionByRank(u, v);
                    add = true;
                }
                if (bob.findUltimateParent(u) != bob.findUltimateParent(v)) {
                    bob.UnionByRank(u, v);
                    add = true;
                }
                if (add) {
                    count++;
                }
            } else if (type == 2) {
                if (bob.findUltimateParent(u) != bob.findUltimateParent(v)) {
                    bob.UnionByRank(u, v);
                    count++;
                }
            } else {
                if (alice.findUltimateParent(u) != alice.findUltimateParent(v)) {
                    alice.UnionByRank(u, v);
                    count++;
                }
            }
        }
        if (alice.components == 1 && bob.components == 1)
            return edges.length - count;
        return -1;
    }
}
