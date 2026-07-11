class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int min=root.val;
        int max=root.val;
        return check(root,min,max);
    }
    private int check(TreeNode root,int min,int max){
        if(root==null){
            return Math.abs(min-max);
        }
        min=Math.min(root.val,min);
        max=Math.max(root.val,max);
        int l=check(root.left,min,max);
        int r=check(root.right,min,max);
        return Math.max(l,r);
    }
}
