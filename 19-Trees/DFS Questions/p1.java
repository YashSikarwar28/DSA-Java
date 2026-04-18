//LC 543 Diameter of a Binary Tree

class Solution {
    static private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        ans = 0;
        recc(root);
        return ans;
    }

    private int recc(TreeNode root) {
        if (root == null)
            return 0;
        int left = recc(root.left);
        int right = recc(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(right, left) + 1;
    }
}