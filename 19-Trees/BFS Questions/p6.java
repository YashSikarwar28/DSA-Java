//LC 199 Right side view
//Easy one similar to p1 and p2

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                if(i==size-1) ans.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
        }
        return ans;
    }
}