//Maintain a min and max variable and keep updating the the root value accordingly
class Solution {
    boolean ans=true;
    public boolean isValidBST(TreeNode root) {
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        check(root,min,max);
        return ans;
    }
    private void check(TreeNode root,long min,long max){
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

        //This code was able to pass majority test cases but failed
        // if(root==null) return;
        // if(root.left!=null && root.left.val>=root.val){
        //     ans=false;
        //     return;
        // }
        // if(root.right!=null && root.right.val<=root.val){
        //     ans=false;
        //     return;
        // }
        // check(root.left);
        // check(root.right);
    }
}
