//LC 101 Symmetric Tree - Values should be mirror image of each other

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode left=q.poll();
            TreeNode right=q.poll();
            if(left==null && right==null) continue;
            
            //conditions where it will become false
            if(left==null || right==null) return false;
            if(left.val!=right.val) return false;

            //adding elements
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}