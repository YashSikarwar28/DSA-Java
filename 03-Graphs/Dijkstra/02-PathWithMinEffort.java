//The only difference is calculating the minimum effort by taking the max diff between the matrix values and then comparing it with the previous value.
class Tuple {
    int eff;
    int i;
    int j;

    Tuple(int eff, int i, int j) {
        this.eff = eff;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    int[] row = { 1, 0, -1, 0 };
    int[] col = { 0, 1, 0, -1 };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.eff, b.eff));
        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int e = t.eff;
            int ii = t.i;
            int jj = t.j;
            if (ii == m - 1 && jj == n - 1)
                return e;
            for (int k = 0; k < 4; k++) {
                int nr = ii + row[k];
                int nc = jj + col[k];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int e2 = Math.max(Math.abs(heights[nr][nc] - heights[ii][jj]), e);
                    if (e2 < dist[nr][nc]) {
                        dist[nr][nc] = e2;
                        pq.add(new Tuple(e2, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}
