class Solution {
    boolean ans=true;
    public boolean isValidBST(TreeNode root) {
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        check(root,min,max);
        return ans;
    }
    private void check(TreeNode root, long min,long max){
        if(root==null) return;
        if(root.val<=min){
            ans=false;
            return;
        }
        if(root.val>=max){
            ans=false;
            return;
        }
        check(root.left,min,root.val);
        check(root.right,root.val,max);
    }
}
