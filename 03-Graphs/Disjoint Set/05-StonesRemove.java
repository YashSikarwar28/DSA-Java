//We dont know the length of array so we take the max value of stone on row and col to get the length which we can use in disjoint set.
//Row numbering will be same but for getting same col as per the row we will add that particular col+maxRow+1 to get the col, then we will apply union by size.
//At last we will loop in hashmap and if the value is equal to the parent we will increase the count and return size-count as ans
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
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

    public void unionBySize(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(stones[i][0], maxRow);
            maxCol = Math.max(stones[i][1], maxCol);
        }
        DisjointSet d = new DisjointSet(maxRow + maxCol + 1);
        //We are using hashmap for storing the stone nodes
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            d.unionBySize(row, col);
            hm.put(row, 1);
            hm.put(col, 1);
        }
        int c = 0;
        for (Map.Entry<Integer, Integer> i : hm.entrySet()) {
            if (d.findUltimateParent(i.getKey()) == i.getKey()) {
                c++;
            }
        }
        return stones.length - c;
    }
}
