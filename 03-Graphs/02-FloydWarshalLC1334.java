//The main logic behind floyd warshal is that it will create a 2d matrix of the smallest distance from every node to every other node and then it can be directly accesed using the index i and j.
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 0; i < edges.length; i++) {
            int j = edges[i][0];
            int k = edges[i][1];
            int weight = edges[i][2];
            dist[j][k] = weight;
            dist[k][j] = weight;
        }
        //Main Floyd warshal algo/syntax
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE)
                        continue;
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}



//The same question can be done using dijkstra only difference is that instead of checking distance only from source to destination we will this time check from every node to every other node in the graph
class Pair {
    int j;
    int dist;

    Pair(int j, int dist) {
        this.j = j;
        this.dist = dist;
    }
}

class PQ {
    int j;
    int dist;

    PQ(int j, int dist) {
        this.j = j;
        this.dist = dist;
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            al.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            al.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        //Running dijkstra on every node 
        for (int i = 0; i < n; i++) {
            PriorityQueue<PQ> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
            pq.add(new PQ(i, 0));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            while (!pq.isEmpty()) {
                PQ p = pq.poll();
                int n1 = p.j;
                int d1 = p.dist;
                if (d1 > dist[n1])
                    continue;
                for (Pair p1 : al.get(n1)) {
                    int n2 = p1.j;
                    int d2 = p1.dist;
                    if (d2 + d1 < dist[n2] && d2 + d1 <= distanceThreshold) {
                        dist[n2] = d2 + d1;
                        pq.add(new PQ(n2, d2 + d1));
                    }
                }
            }
            int c = 0;
            for (int l = 0; l < n; l++) {
                if (l != i && dist[l] <= distanceThreshold) {
                    c++;
                }
            }
            if (c <= min) {
                min = c;
                ans = i;
            }
        }
        return ans;
    }
}
