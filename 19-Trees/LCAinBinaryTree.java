//For a node to become lca it should be the parent of p and q.
//p and q are their own boss or parent so they are given one value and all other as zero.
//When a node comes which contains both p and q it will return 2 and that particular first node will be our answer.
class Solution {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        dfs(root, p, q);
        return ans;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int self = 0;
        if (root == p || root == q) {
            self = 1;
        }
        int total = 0;
        total = left + right + self;
        if (total == 2 && ans == null) {
            ans = root;
        }
        return total;
    }
}
