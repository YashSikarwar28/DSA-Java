//This question has 3 cases either the value of left and right subtree + root.val could be the best
//or either root left and root val or root right and root val could be the best
//or both left and right contains negative so only root val is good
//we will use normal dfs left and right recursive call and then use the 3 case to test and get the max answer for all 3
//finally return max of left and right

class Solution {
    int ans;
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        check(root);
        return ans;
    }
    private int check(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=check(root.left);
        int r=check(root.right);

        int down_ans=l+r+root.val;
        int only_one=Math.max(l,r)+root.val;
        int only_root=root.val;
        
        ans=Math.max(ans,Math.max(Math.max(only_one,only_root),down_ans));
        return Math.max(only_one,only_root);
    }
}
