//LC-2762
//We need to keep track of min and max element in the arrays as we loop, for that we take 2 deque int will store the min and one will store max till that particular index. While removing the element which will be done when the condition becomes false we will check whether the index we are removing is the current index or not and then we will update the j pointer.
class Solution {
    public long continuousSubarrays(int[] a) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int j = 0;
        long c = 0;
        for (int i = 0; i < a.length; i++) {
            //min deque
            while (!min.isEmpty() && a[min.peekLast()] >= a[i]) {
                min.pollLast();
            }
            min.addLast(i);
            //max deque
            while (!max.isEmpty() && a[max.peekLast()] <= a[i]) {
                max.pollLast();
            }
            max.addLast(i);
            while (a[max.peekFirst()] - a[min.peekFirst()] > 2) {
                if (min.peekFirst() == j) {
                    min.pollFirst();
                }
                if (max.peekFirst() == j) {
                    max.pollFirst();
                }
                j++;
            }
            c += i - j + 1;
        }
        return c;
    }
}
