//Question is easy but identifying base case is slightly tricky.
//For this question instead of calculating s1 and s2, derive the formula and calculate the answer accordingly.
//Base case is that the difference should not be less than zero and and it should not be odd. 
class Solution {
	public int countPartitions(int[] arr, int diff) {
		int totalsum = Arrays.stream(arr).sum();
		if((totalsum-diff)<0 || (totalsum-diff)%2!=0) return 0;
		int target = (totalsum - diff)/2;
		int[][] dp = new int[arr.length + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j <= target; j++) {
				int not_take = dp[i - 1][j];
				int take = 0;
				if (arr[i - 1] <= j) {
					take = dp[i - 1][j - arr[i - 1]];
				}
				dp[i][j] = not_take + take;
			}
		}
		return dp[arr.length][target];
	}
}



class Solution {
	public int countPartitions(int[] arr, int diff) {
		int totalsum = Arrays.stream(arr).sum();
		int target = (totalsum - diff)/2;
		if ((totalsum - diff)%2 != 0 || (totalsum - diff)<0)
			return 0;
		int[][] dp = new int[arr.length][totalsum];
		for (int i = 0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return check(arr, diff, 0, 0, target, dp);
	}
	private int check(int[] arr, int diff, int sum, int ind, int target, int[][] dp) {
		if (ind == arr.length) {
			return sum == target?1:0;
		}
		if (dp[ind][sum] != -1)
			return dp[ind][sum];
		int not_take = check(arr, diff, sum, ind + 1, target, dp);
		int take = 0;
		if (arr[ind] <= target) {
			take = check(arr, diff, sum + arr[ind], ind + 1, target, dp);
		}
		return dp[ind][sum] = take + not_take;
	}
}



//Meet in the middle
//This approach is also similar to other MITM question the tricky part is to derive the formula and the apply binary search 2 time to calculate the target before and after so that we get a range where the target occurs and then we can subtract the 2 ranges and add to our answer.
class Solution {
	public int countPartitions(int[] arr, int diff) {
		int l = arr.length/2;
		int r = arr.length - l;
		int totalsum = Arrays.stream(arr).sum();
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		if (totalsum + diff < 0 || (totalsum + diff) % 2 != 0) {
			return 0;
		}
		for (int mask = 0; mask<(1 << l); mask++) {
			int s = 0;
			for (int i = 0; i<l; i++) {
				if ((mask&(1 << i)) != 0) {
					s += arr[i];
				}
			}
			left.add(s);
		}
		for (int mask = 0; mask<(1 << r); mask++) {
			int s = 0;
			for (int i = 0; i<r; i++) {
				if ((mask&(1 << i)) != 0) {
					s += arr[i + l];
				}
			}
			right.add(s);
		}
		Collections.sort(right);
		int c = 0;
		for (int i = 0; i<left.size(); i++) {
			int low = 0;
			int high = right.size();
			//int target = diff - left.get(i);
			int target = (totalsum + diff) / 2 - left.get(i);
			while (low < high) {
				int mid = low + (high - low)/2;
				if (right.get(mid)<target) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			int firstoccur = low;
			low = 0;
			high = right.size();
			while (low < high) {
				int mid = low + (high - low)/2;
				if (right.get(mid) <= target) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			int secondoccur = low;
			c += secondoccur - firstoccur;
		}
		return c;
	}
}
