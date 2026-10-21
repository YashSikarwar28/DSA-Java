//Divide the array in 2 halves and then use bit mask to create subset of both parts and add them in 2 different arraylist, then sort the list and loop in the left part and compare it with the right part.
//We want to calculate the sum clost to our goal for then we will use binary search and calculate the answer accordingly.
class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int l = nums.length / 2;
        int r = nums.length - l;
        int sum = Arrays.stream(nums).sum();
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int mask = 0; mask < (1 << l); mask++) {
            int s = 0;
            for (int i = 0; i < l; i++) {
                if ((mask & (1 << i)) != 0) {
                    s += nums[i];
                }
            }
            left.add(s);
        }
        for (int mask = 0; mask < (1 << r); mask++) {
            int s = 0;
            for (int i = 0; i < r; i++) {
                if ((mask & (1 << i)) != 0) {
                    s += nums[l + i];
                }
            }
            right.add(s);
        }
        Collections.sort(right);
        int ans = Integer.MAX_VALUE;
        //sum-goal, sum=right+left, right=sum-left
        for (int i = 0; i < left.size(); i++) {
            int leftsum = left.get(i);
            int target = goal - leftsum;
            int low = 0;
            int high = right.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int rightsum = right.get(mid);
                int reqSum = Math.abs((rightsum + leftsum) - goal);
                ans = Math.min(ans, reqSum);
                if (rightsum < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
}
