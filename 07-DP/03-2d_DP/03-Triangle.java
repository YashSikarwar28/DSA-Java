//This question is all about how to iterate and apply DP on arraylist instead of a 2d array, take a good look at the syntax.
//We have to start from the first and find min sum to the last row, the catch is we have to find in last row that is we have to check all the numbers of last row.
//Take a dp list and use a default loop which you use just use Collections.min for the last row which will directly give the smallest answer in that row.
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(0);
            }
            dp.add(row);
        }
        dp.get(0).set(0, triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = triangle.get(i).get(j)
                        + (j < dp.get(i - 1).size() ? dp.get(i - 1).get(j) : (int) 1e9);

                int diagonal = triangle.get(i).get(j) + (j > 0 ? dp.get(i - 1).get(j - 1) : (int) 1e9);
                dp.get(i).set(j, Math.min(down, diagonal));
            }
        }
        return Collections.min(dp.get(dp.size() - 1));
    }
}

//Gives TLE
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         List<List<Integer>> dp = new ArrayList<>();
//         for (int i = 0; i < triangle.size(); i++) {
//             List<Integer> row=new ArrayList<>();
//             for (int j = 0; j < triangle.get(i).size(); j++) {
//                 row.add(-1);
//             }
//             dp.add(row);
//         }
//         return check(triangle, dp, 0, 0);
//     }

//     private int check(List<List<Integer>> triangle, List<List<Integer>> dp, int i, int j) {
//         if (i >= triangle.size() || j >= triangle.get(i).size()) {
//             return (int) 1e9;
//         }
//         if (i == triangle.size() - 1) {
//             return triangle.get(i).get(j);
//         }
//         if (dp.get(i).get(j) != -1) {
//             return dp.get(i).get(j);
//         }
//         int down = triangle.get(i).get(j) + check(triangle, dp, i + 1, j);
//         int diagonal = triangle.get(i).get(j) + check(triangle, dp, i + 1, j + 1);

//          This is not used while returning wrong syntax
//          return dp.get(i).set(j, Math.min(down, diagonal));

//         // correct syntax
//         int ans=Math.min(down,diagonal);
//         dp.get(i).set(j,ans);
//         return ans;
//     }
// }

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         return check(triangle, 0, 0);
//     }

//     private int check(List<List<Integer>> triangle, int i, int j) {
//         if (i >= triangle.size() || j >= triangle.get(i).size())
//             return (int) 1e9;
//         if (i == triangle.size() - 1) {
//             return triangle.get(i).get(j);
//         }
//         int down = triangle.get(i).get(j) + check(triangle, i + 1, j);
//         int diagonal = triangle.get(i).get(j) + check(triangle, i + 1, j + 1);
//         return Math.min(down, diagonal);
//     }
// }
