//LC 230-Kth Smallest Element in a BST

//using counter to stop when k value matches
class Solution {
    private static int count;
    private static int ans;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = 0;
        check(root, k);
        return ans;
    }

    private void check(TreeNode root, int k) {
        if (root == null)
            return;
        check(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
        }
        check(root.right, k);
    }
}

// using arraylist
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        check(a, root, k);
        return a.get(k - 1);
    }

    private void check(ArrayList<Integer> a, TreeNode root, int k) {
        if (root == null)
            return;

        check(a, root.left, k);
        a.add(root.val);
        check(a, root.right, k);
    }
}