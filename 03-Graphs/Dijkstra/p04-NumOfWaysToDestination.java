//LC 1976
//We have to find number of ways to reach destination so one node to previous destination we will see how mant different ways are there and then add it to our destination node, we will maintain a distance arrays and ways array where we will cmpute different ways to reach a particular node and a distance array to update the distance which we have already done in previous questions.
//If the distance is smaller we will update the distance array and add it in PQ
//One more check for this particular question if the previous distance and the new distance is equal we will update the ways arrays as thats what the question asks for.
class Pair {
    //int i;
    int j;
    int dist;

    Pair(int j, int dist) {
        //this.i=i;
        this.j = j;
        this.dist = dist;
    }
}
class PQ {
    int node;
    long dist;

    PQ(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            al.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            al.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<PQ> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new PQ(0, 0));
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        Arrays.fill(ways, 0);
        ways[0] = 1;
        int mod = (int) 1e9 + 7;
        while (!pq.isEmpty()) {
            PQ p = pq.poll();
            int nd = p.node;
            long ds = p.dist;
            if (ds > dist[nd])
                continue;
            for (Pair pp : al.get(nd)) {
                int newNode = pp.j;
                long newDist = pp.dist;
                if (newDist + ds < dist[newNode]) {
                    dist[newNode] = newDist + ds;
                    pq.add(new PQ(newNode, dist[newNode]));
                    ways[newNode] = ways[nd];
                }
                //This is the main difference part, if distance is equal we will update the ways array and its value will be equal to previous node + current node;  
                else if (newDist + ds == dist[newNode]) {
                    ways[newNode] = (ways[newNode] + ways[nd]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}
