//The main thing to notice here is if the sign is = then both should have he same parent and if it is ! then they should not have the same parent
//Also in this the input is in string so look at that syntax properly.
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
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        DisjointSet d = new DisjointSet(26);
        for (int i = 0; i < equations.length; i++) {
            String st = equations[i];
            int a = st.charAt(0) - 'a';
            int b = st.charAt(3) - 'a';
            if (st.charAt(1) == '=') {
                d.UnionByRank(a, b);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String st = equations[i];
            int a = st.charAt(0) - 'a';
            int b = st.charAt(3) - 'a';
            if (st.charAt(1) == '!' && d.findUltimateParent(a) == d.findUltimateParent(b)) {
                return false;
            }
        }
        return true;
    }
}
