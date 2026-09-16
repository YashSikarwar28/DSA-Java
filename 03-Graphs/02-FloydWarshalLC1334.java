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
ArrayList<ArrayList<Pair2>> al = new ArrayList<>();

for (int i = 0; i < n; i++) {
    al.add(new ArrayList<>());
}

for (int i = 0; i < edges.length; i++) {
    al.get(edges[i][0]).add(new Pair2(edges[i][1], edges[i][2]));
    al.get(edges[i][1]).add(new Pair2(edges[i][0], edges[i][2]));
}

int ans = -1;
int minCount = Integer.MAX_VALUE;

// Run Dijkstra from every node
for (int src = 0; src < n; src++) {

    PriorityQueue<Pair> pq =
        new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

    pq.add(new Pair(src, 0));

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[src] = 0;

    while (!pq.isEmpty()) {

        Pair pp = pq.poll();

        int n1 = pp.node;
        int d1 = pp.dist;

        // Ignore outdated entry
        if (d1 > dist[n1]) {
            continue;
        }

        for (Pair2 p2 : al.get(n1)) {

            int n2 = p2.j;
            int d2 = p2.dist;

            int newDist = d1 + d2;

            if (newDist <= distanceThreshold && newDist < dist[n2]) {

                dist[n2] = newDist;

                pq.add(new Pair(n2, newDist));
            }
        }
    }

    // Count cities reachable from src
    int count = 0;

    for (int i = 0; i < n; i++) {

        if (i != src && dist[i] <= distanceThreshold) {
            count++;
        }
    }

    // If same count, choose larger city number
    if (count <= minCount) {
        minCount = count;
        ans = src;
    }
}

return ans;
