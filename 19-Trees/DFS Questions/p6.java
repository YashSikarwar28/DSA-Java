//LC 236-Lowest Common Ancestor of a Binary Tree
//Traverse left and right if found both p and q return that node else if found a particular node either p or q then return that specific node from where you found left or right

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;

        if(root==p || root==q) return root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null) return root;
        return left==null ? right:left;
    }
}