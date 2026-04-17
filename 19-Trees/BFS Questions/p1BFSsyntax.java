//BFS also known as level order traversal

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ds=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                ds.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            ans.add(ds);
        }
        //reversing not required for question purpose
        //Collections.reverse(ans);
        return ans;
    }
}