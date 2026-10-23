//First create a seperate class for hashmap which will contain the source and dest+val and the second class for queue which will contains the current node and the sum
//Initialize the hashmap take a look at the syntax carefullyy!!
//Then start looping on the queries and add them in queue and call the BFS on it, use a hashset so that value get process only once.
//Have a look at the syntax as it requires arraylist instead of array and double instead of an integer
//BFS is similar to what we have done previously.
class Pair {
    String dest;
    double val;

    Pair(String dest, double val) {
        this.dest = dest;
        this.val = val;
    }
}

class QQ {
    String start;
    double amt;

    QQ(String start, double amt) {
        this.start = start;
        this.amt = amt;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> hm = new HashMap<>();
        double[] ans = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            if (!hm.containsKey(equations.get(i).get(0))) {
                hm.put(equations.get(i).get(0), new ArrayList<>());
            }
            if (!hm.containsKey(equations.get(i).get(1))) {
                hm.put(equations.get(i).get(1), new ArrayList<>());
            }
            hm.get(equations.get(i).get(0)).add(new Pair(equations.get(i).get(1), values[i]));
            hm.get(equations.get(i).get(1)).add(new Pair(equations.get(i).get(0), 1.0 / values[i]));
        }

        for (int i = 0; i < queries.size(); i++) {
            if (!hm.containsKey(queries.get(i).get(0)) || !hm.containsKey(queries.get(i).get(1))) {
                ans[i] = -1;
                continue;
            }
            Queue<QQ> q = new LinkedList<>();
            q.add(new QQ(queries.get(i).get(0), 1.0));
            HashSet<String> hs = new HashSet<>();
            hs.add(queries.get(i).get(0));
            ans[i] = bfs(q, hs, queries.get(i).get(1), hm);
        }
        return ans;
    }

    private double bfs(Queue<QQ> q, HashSet<String> hs, String tar,
            HashMap<String, List<Pair>> hm) {
        while (!q.isEmpty()) {
            QQ qq = q.poll();
            String st = qq.start;
            double amount = qq.amt;
            if (st.equals(tar)) {
                return amount;
            }
            for (Pair p : hm.getOrDefault(st, new ArrayList<>())) {
                String newst = p.dest;
                double vall = p.val;
                if (!hs.contains(newst)) {
                    hs.add(newst);
                    q.add(new QQ(newst, vall * amount));
                }
            }
        }
        return -1.0;
    }
}
