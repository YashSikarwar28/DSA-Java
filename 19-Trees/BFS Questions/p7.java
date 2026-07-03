//LC 993 Cousins in binary tree
//cousins means they must be on same level and they must not be siblings that is they must have different parents


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int child=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                int parent=0;
                TreeNode t=q.poll();
                if(t.left!=null){
                    if(t.left.val==x || t.left.val==y){
                        child++;
                        parent++;
                    }
                    q.add(t.left);
                }
                if(t.right!=null){
                    if(t.right.val==x || t.right.val==y){
                        child++;
                        parent++;
                    }
                    q.add(t.right);
                }
                if(parent==2) return false;
            }
            if(child==2) return true;
            if(child==1) return false;
        }
        return false;
    }
}
