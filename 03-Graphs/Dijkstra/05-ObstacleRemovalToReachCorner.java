//LC 2290
//Its like normal dijkstra onlt use a PQ to store dist,row,col and then traverse in PQ check the distance conditon, if distance is smaller move ahead.
class Tuple {
    int dist;
    int row;
    int col;

    Tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int[] r = { 1, 0, -1, 0 };
    int[] c = { 0, 1, 0, -1 };

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Tuple(0, 0, 0));
        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            int i = t.row;
            int j = t.col;
            int dis = t.dist;
            if (dis > dist[i][j])
                continue;
            if (i == m - 1 && j == n - 1)
                return dist[i][j];
            for (int k = 0; k < 4; k++) {
                int nr = i + r[k];
                int nc = j + c[k];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && dis + grid[nr][nc] < dist[nr][nc]) {
                    dist[nr][nc]=dis+grid[nr][nc];
                    pq.add(new Tuple(dis + grid[nr][nc], nr, nc));
                }
            }
        }
        return 0;
    }
}
