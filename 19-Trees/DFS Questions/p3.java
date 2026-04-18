//LC 108 - Sorted array to BST

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private TreeNode sort(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode t = new TreeNode(nums[mid]);

        t.left = sort(nums, start, mid - 1);
        t.right = sort(nums, mid + 1, end);

        return t;
    }
}