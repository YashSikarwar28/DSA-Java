//We will check if root.val falls between the low and high range and add it to sum if it does not then we will check if val>high we will go left if val<low we will go right.
class Solution {
    long sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum=0;
        check(root,low,high);
        return (int)sum;
    }
    private void check(TreeNode root, int low, int high){
        if(root==null) return;
        if(root.val<low){
            check(root.right,low,high);
            return;
        }
        if(root.val>high){
            check(root.left,low,high);
            return;
        }
        sum+=root.val;
        check(root.left,low,high);
        check(root.right,low,high);
    }
}
