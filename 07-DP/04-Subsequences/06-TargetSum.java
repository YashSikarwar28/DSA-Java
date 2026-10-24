// s1-s2=target
// s1+s2=total
// s1=(target+total)/2;

//Meet in the Middle - dp is better than MITM but still did as it can be done using this approach as well.
//Same process just take care of the binary search part and how to calculate the target which we are looking for.
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = Arrays.stream(nums).sum();
        if ((totalsum + target) % 2 != 0)
            return 0;
        int newtarget = (totalsum + target) / 2;
        int l = nums.length / 2;
        int r = nums.length - l;
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
                    s += nums[i + l];
                }
            }
            right.add(s);
        }
        Collections.sort(right);
        int ans = 0;
        for (int i = 0; i < left.size(); i++) {
            int lsum = left.get(i);
            int tarr = newtarget - lsum;
            int low = 0;
            int high = right.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (right.get(mid) < tarr) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int lInd = low;
            low = 0;
            high = right.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (right.get(mid) <= tarr) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int rInd = low;
            ans += rInd - lInd;
        }
        return ans;
    }
}

//Tabulation
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = Arrays.stream(nums).sum();
        int newtar = (target + totalsum) / 2;
        if (target + totalsum < 0 || (target + totalsum) % 2 != 0)
            return 0;
        int[][] dp = new int[nums.length+1][newtar + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= newtar; j++) {
                int not_take = dp[i - 1][j];
                int take = 0;
                if (nums[i-1] <= j) {
                    take = dp[i - 1][j - nums[i-1]];
                }
                dp[i][j] = not_take + take;
            }
        }
        return dp[nums.length][newtar];
    }
}

//Memoization
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = Arrays.stream(nums).sum();
        int newtar = (totalsum + target) / 2;
        if ((totalsum + target) < 0 || (totalsum + target) % 2 != 0)
            return 0;
        int[][] dp = new int[nums.length][newtar + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return check(nums, 0, newtar, dp);
    }

    private int check(int[] nums, int ind, int newtar, int[][] dp) {
        if (ind == nums.length) {
            if (newtar == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[ind][newtar] != -1)
            return dp[ind][newtar];
        int not_take = check(nums, ind + 1, newtar, dp);
        int take = 0;
        if (nums[ind] <= newtar) {
            take = check(nums, ind + 1, newtar - nums[ind], dp);
        }
        return dp[ind][newtar] = not_take + take;
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }
        return check(nums, target, 0, dp);
    }

    private int check(int[] nums, int target, int ind, int[][] dp) {
        if (ind == nums.length) {
            if (target == 0) {
                return 1;
            }
            return (int) 1e9;
        }
        if (dp[ind][target] != (int) 1e9)
            return dp[ind][target];
        int take1 = check(nums, target - nums[ind], ind + 1, dp);
        int take2 = check(nums, target + nums[ind], ind + 1, dp);
        return dp[ind][target] = take1 + take2;
    }
}
