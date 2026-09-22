//First we will traverse through all ones and give them size using the disjoint set and then similarly we will traverse through 0 in the next loop and will find the ultimate parent of the corresponding one, in the second loop we will use hashset so that it only stores unique value and no duplicate, then we will traverse the hashset and will update the answer.
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
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
            // both equal connect anyone
            parent.set(ulp_u, ulp_v);
            int r = rank.get(ulp_v);
            rank.set(ulp_v, r + 1);
        }
    }

    public void size(int u, int v) {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet d = new DisjointSet(n * n);
        int[] row = { 1, 0, -1, 0 };
        int[] col = { 0, 1, 0, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + row[k];
                    int nc = j + col[k];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                        int prevr = i * n + j;
                        int newr = nr * n + nc;
                        d.size(prevr, newr);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    continue;
                HashSet<Integer> hs = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = row[k] + i;
                    int nc = col[k] + j;
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1) {
                        hs.add(d.findUltimateParent(nr * n + nc));
                    }
                }
                int c = 0;
                for (int k : hs) {
                    c += d.size.get(k);
                }
                //count the itself node as well thats why +1;
                ans = Math.max(ans, c + 1);
            }
        }
      //if ans=0 that means no 0 is present
        return ans == 0 ? n * n : ans;
    }
}


//In this approach we first traverse through all ones and assign them an id in a hashmap like 2,3 etc. Then we apply dfs from that one and increase the area and after the dfs update the area in the hashmap to that correcponding id.
//Then we traverse through the zeros and find the adjacent ones which can be uniquely identified by the ids and from those ids we can get the area of that particular one block of cells. In second loop we will use hashset for storing only the unique values.
//Finally we will run loop on hashset and update our answer.
class Solution {
    int area;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        boolean[][] b = new boolean[n][n];
        int ans = 0;
        int id = 2;
        HashMap<Integer, Integer> hm = new HashMap<>(); //id, size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !b[i][j]) {
                    area = 0;
                    dfs(grid, b, i, j, id);
                    ans = Math.max(ans, area);
                    hm.put(id, area);
                    id++;
                }
            }
        }
        int[] row = { 1, 0, -1, 0 };
        int[] col = { 0, 1, 0, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> hs = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nr = i + row[k];
                        int nc = j + col[k];
                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] > 1) {
                            hs.add(grid[nr][nc]);
                        }
                    }
                    int size = 1;
                    for (int ind : hs) {
                        size += hm.get(ind);
                    }
                    ans = Math.max(ans, size);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, boolean[][] b, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || b[i][j] || grid[i][j] == 0)
            return;
        b[i][j] = true;
        //Marking the ones with the particular id
        grid[i][j] = id;
        area++;
        dfs(grid, b, i + 1, j, id);
        dfs(grid, b, i - 1, j, id);
        dfs(grid, b, i, j + 1, id);
        dfs(grid, b, i, j - 1, id);
    }
}



//Brute Force - TC : O(n4) - TLE
//Treverse through the array and only through the zero value, then update the zero value to one and again trverse through the array from start index and apply dfs and update the answer.
//Its like travelling thorugh all zeros applying dfs and updating the answer and repeating the process
class Solution {
    int area;
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    grid[i][j]=1;
                    boolean[][] b=new boolean[n][n];
                    int max=0;
                    for(int x=0;x<n;x++){
                        for(int y=0;y<n;y++){
                            if(grid[x][y]==1 && !b[x][y]){
                                area=0;
                                dfs(grid,x,y,b);
                                max=Math.max(max,area);
                            }
                        }
                    }
                    grid[i][j]=0;
                    ans=Math.max(ans,max);
                }
            }
        }
        if(ans==0) return n*n;
        return ans;
    }
    private void dfs(int[][] grid,int x,int y,boolean[][] b){
        if(x<0 || y<0 || x>=grid.length || y>=grid.length || b[x][y] || grid[x][y]==0) return;
        b[x][y]=true;
        area++;
        dfs(grid,x+1,y,b);
        dfs(grid,x-1,y,b);
        dfs(grid,x,y+1,b);
        dfs(grid,x,y-1,b);
    }
}
