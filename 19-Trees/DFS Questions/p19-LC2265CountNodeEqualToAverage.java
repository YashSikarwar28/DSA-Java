//Use postorder to count the sum and count and then take avg and check if its equal to the sum;
class Solution {
    int ans;
    class Pair{
        int sum;
        int count;
        Pair(int sum,int count){
            this.sum=sum;
            this.count=count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        ans=0;
        dfs(root);
        return ans;
    }
    private Pair dfs(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair left=dfs(root.left);
        Pair right=dfs(root.right);
        int s=left.sum+right.sum+root.val;
        int c=left.count+right.count+1;
        if(root.val==(s/c)){
            ans++;
        }
        return new Pair(s,c);
    }
}
