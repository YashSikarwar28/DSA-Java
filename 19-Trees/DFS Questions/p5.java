//LC 114 Flatten Binary Tree
//Morris Traversal Preorder

public void flatten(TreeNode root) {
    if (root == null)
        return;
    TreeNode t = root;
    while (t != null) {
        if (t.left == null) {
            t = t.right;
        } else {
            TreeNode ll = t.left;
            while (ll.right != null) {
                ll = ll.right;
            }
            ll.right = t.right;
            t.right = t.left;
            t.left = null;

            t = t.right;
        }
    }
}