//LC 637 Average of Levels - BFS

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> d=new ArrayList<>();
        if(root==null) return d;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            double size=q.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                sum+=t.val;
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            d.add(sum/size);
        }
        return d;
    }
}