//Instead of checking distance between 2 nodes we will check the stops and every time the stops will increase by one thats why we can use a queue instead of a priority.
//We will use arraylist class pair because the diagram consists of nodes and not matrix like we have in previous question.
//Then we will check the stops condition and the distance conditon like we have done in previous questions and update accordingly.
//We will also take a distance array which will store the distance and can diretly return the destination value as the answer.
class Pair {
    int node;
    int dest;

    Pair(int node, int dest) {
        this.node = node;
        this.dest = dest;
    }
}

class Tuple {
    int stops;
    int i;
    int j;

    Tuple(int stops, int i, int j) {
        this.stops = stops;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            al.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new Tuple(0, src, 0));
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int d = t.stops;
            int ii = t.i;
            int jj = t.j;
            if (d > k)
                continue;
            for (Pair pp : al.get(ii)) {
                int newNode = pp.node;
                int newDest = pp.dest;
                if (newDest + jj < dist[newNode] && d <= k) {
                    dist[newNode] = newDest + jj;
                    q.add(new Tuple(d + 1, newNode, newDest + jj));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE)
            return -1;
        return dist[dst];
    }
}
