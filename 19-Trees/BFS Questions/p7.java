//LC 993 Cousins in binary tree
//cousins means they must be on same level and they must not be siblings that is they must have different parents


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx=findNode(root,x);
        TreeNode yy=findNode(root,y);
        return((level(root,xx,0)==level(root,yy,0)) && !isSiblings(root,xx,yy));
    }
    private TreeNode findNode(TreeNode root,int x){
        if(root==null) return null;
        if(root.val==x) return root;
        TreeNode n=findNode(root.left,x);
        if(n!=null) return n;
        return findNode(root.right,x);
    }
    private boolean isSiblings(TreeNode root,TreeNode xx,TreeNode yy){
        if(root==null) return false;
        return((root.left==xx && root.right==yy)||
        (root.left==yy && root.right==xx) ||
        isSiblings(root.left,xx,yy) ||
        isSiblings(root.right,xx,yy));
    }
    private int level(TreeNode root,TreeNode xx,int lev){
        if(root==null) return 0;
        if(root==xx) return lev;
        int n=level(root.left,xx,lev+1);
        if(n!=0) return n;
        return level(root.right,xx,lev+1);
    }
}