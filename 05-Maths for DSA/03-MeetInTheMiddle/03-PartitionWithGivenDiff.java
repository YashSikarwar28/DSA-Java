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
    //Calculating lower and upper bound for the particular target
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
