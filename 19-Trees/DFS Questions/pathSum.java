//Subtract current root val and then go to left and then check the path sum condition if correct then return true otherwise go right
class Solution {
    boolean ans;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        ans=false;
        check(root,targetSum);
        return ans;
    }
    private void check(TreeNode root,int targetSum){
        if(root==null) return;
        targetSum-=root.val;
        check(root.left,targetSum);
        if(targetSum==0 && (root.left==null && root.right==null)){
            ans=true;
        }
        check(root.right,targetSum);
    }
}
