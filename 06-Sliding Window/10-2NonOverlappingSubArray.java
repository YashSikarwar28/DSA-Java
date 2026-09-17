//LC -1447 - Inovolves overlapping concept as well
//Initially I used the string overlapping concept using 2 pointers and when we find a window i will update the last pointer to current subarray start but that approach did not work was able to pass few test cases, the main problem with that approach was that it was not able to track the 2 minimum length subarray.
//In this approach we mainatined an array and if we find a particular subarray sum==target we will check that array previous index whether we find any shorter length subarray and then we can update the sum by taking the current length + the previous subarray index length.
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int j = 0;
        int[] minTillInd = new int[arr.length];
        Arrays.fill(minTillInd, Integer.MAX_VALUE);
        int sum = 0;
        int resLen = Integer.MAX_VALUE;
        int resSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target && j < i) {
                sum -= arr[j++];
            }
            //main part
            if (sum == target) {
                if (j > 0 && minTillInd[j - 1] != Integer.MAX_VALUE) {
                    resSum = Math.min(resSum, i - j + 1 + minTillInd[j - 1]);
                }
                resLen = Math.min(resLen, i - j + 1);
            }
            minTillInd[i] = resLen;
        }
        return resSum == Integer.MAX_VALUE ? -1 : resSum;
    }
}
