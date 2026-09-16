//Main thing for this quesion is to find the distance between 2 bombs using euclidian formula and check if the radius of that particular bomb is greter than or equal to the caluclated distance if true add it in adjacency list otherwise leave it.
//Then just apply dfs and calculate the answer
class Solution {
    public int maximumDetonation(int[][] bombs) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long radius=bombs[i][2];
                long dis = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                if (radius * radius >= dis) {
                    al.get(i).add(j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < bombs.length; i++) {
            ArrayList<Integer> aa = new ArrayList<>();
            boolean[] visited = new boolean[bombs.length];
            dfs(al, i, aa, visited);
            int ss = aa.size();
            ans = Math.max(ans, ss);
        }
        return ans;
    }

    private void dfs(ArrayList<ArrayList<Integer>> al, int i, ArrayList<Integer> aa, boolean[] visited) {
        aa.add(i);
        visited[i] = true;
        for (int j : al.get(i)) {
            if (!visited[j]) {
                dfs(al, j, aa, visited);
            }
        }
    }
}
