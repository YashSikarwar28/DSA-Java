//Meet in the middle
//Split the array into 2 equal size
//Create a hashmap of count and sum arraylist for left and right
//calculate subset for left and right repectively and insert into hashmap
//sort the right hashmap
//loop in left hashmap sum values and then apply binary search
class Solution {
    public int minimumDifference(int[] nums) {
        int size = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        //splitting in two
        int n1 = size / 2;
        int n2 = size / 2;
        HashMap<Integer, ArrayList<Integer>> left = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> right = new HashMap<>();
        for (int i = 0; i <= n1; i++) {
            left.put(i, new ArrayList<>());
            right.put(i, new ArrayList<>());
        }
        //calculating left subset using power set method
        for (int mask = 0; mask < (1 << n1); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n1; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    count++;
                }
            }
            left.get(count).add(sum);
        }
        //caluclating right subset
        for (int mask = 0; mask < (1 << n2); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < n2; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[n2 + i];
                    count++;
                }
            }
            right.get(count).add(sum);
        }
        //sorting the right half
        for (int i = 0; i < right.size(); i++) {
            ArrayList<Integer> al = right.get(i);
            Collections.sort(al);
        }
        int ans = Integer.MAX_VALUE;

        //comparing left and right
        for (int i = 0; i < left.size(); i++) {
            int rightsize = n1 - i;
            //left=n elements,right=size-n elements
            ArrayList<Integer> al_left = left.get(i);
            ArrayList<Integer> al_right = right.get(rightsize);
            for (int j : al_left) {
                int bestRightSum = (totalSum - 2 * j) / 2;
                //applying binary search on the right values
                int low = 0;
                int high = al_right.size() - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    int rightsum = al_right.get(mid);
                    int diff = Math.abs(totalSum - 2 * (j + rightsum));
                    ans = Math.min(ans, diff);
                    if (rightsum < bestRightSum) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return ans;
    }
}
