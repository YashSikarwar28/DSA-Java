//Can also be done using dfs
//In DSU part we will take a sum AL because we want the sum of the grid values.
//2D array - row=i/grid[0].length and col=i%grid[0].length and node=i*grid[0].length+j
//First initialize it with grid values and then in size DSU update the sum as you update the size.
//Here we will loop through the non zero values and then go in 4 directions and apply size DSU.
//Then we will loop m*n times because DSU cannot be applied on 2d arrays and here we will check that our value is not zero and its the superparent and the overall value is divisble by zero.
class Disjoint {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Long> sum = new ArrayList<>();

    public Disjoint(int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
            int row = i / grid[0].length;
            int col = i % grid[0].length;
            sum.add((long) grid[row][col]);
        }
    }

    public int superParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int n1 = superParent(parent.get(node));
        parent.set(node, n1);
        return parent.get(node);
    }

    public void size(int u, int v) {
        int par_u = superParent(u);
        int par_v = superParent(v);
        if (par_u == par_v) {
            return;
        }
        if (size.get(par_u) < size.get(par_v)) {
            parent.set(par_u, par_v);
            sum.set(par_v, sum.get(par_v) + sum.get(par_u));
            size.set(par_v, size.get(par_v) + size.get(par_u));
        } else {
            parent.set(par_v, par_u);
            sum.set(par_u, sum.get(par_u) + sum.get(par_v));
            size.set(par_u, size.get(par_u) + size.get(par_v));
        }
    }
}

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Disjoint dsu = new Disjoint(m * n, grid);
        int[] row = { 1, 0, -1, 0 };
        int[] col = { 0, 1, 0, -1 };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int node = i * grid[0].length + j;
                    for (int x = 0; x < 4; x++) {
                        int nr = i + row[x];
                        int nc = j + col[x];
                        if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] != 0) {
                            int newnode = nr * grid[0].length + nc;
                            dsu.size(node, newnode);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m * n; i++) {
            int r = i / grid[0].length;
            int c = i % grid[0].length;
            if (grid[r][c] != 0 && dsu.superParent(i) == i && dsu.sum.get(i) % k == 0) {
                ans++;
            }
        }
        return ans;
    }
}
