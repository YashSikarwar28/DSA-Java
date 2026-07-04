class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans=0;
        path(root);
        return ans;
    }
    private int path(TreeNode root){
        if(root==null) return 0;
        int l=path(root.left);
        int r=path(root.right);
        int left=0;
        int right=0;
        if(root.left!=null && root.left.val==root.val){
            left=l+1;
        }
        if(root.right!=null && root.right.val==root.val){
            right=r+1;
        }
        ans=Math.max(ans,right+left);
        return Math.max(right,left);
    }
}
