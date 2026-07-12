class Solution {
    //Find parent node of all nodes
    //From the target go left, right and up using the parent node and put in hashset as those nodes are visited
    //when h=0 break the loop and print the values
    HashMap<TreeNode, TreeNode> h=new HashMap<>();
    private void parent(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            h.put(root.left,root);
        }
        parent(root.left);
        if(root.right!=null){
            h.put(root.right,root);
        }
        parent(root.right);
    }
    private void visited(TreeNode target, int k,List<Integer> ans){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> hs=new HashSet<>();
        hs.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(k==0) break;
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                if(t.left!=null && !hs.contains(t.left)){
                    q.add(t.left);
                    hs.add(t.left);
                }
                if(t.right!=null && !hs.contains(t.right)){
                    q.add(t.right);
                    hs.add(t.right);
                }
                if(h.containsKey(t) && !hs.contains(h.get(t))){
                    q.add(h.get(t));
                    hs.add(h.get(t));
                }
            }
            k--;
        }
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            ans.add(t.val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        parent(root);
        visited(target,k,ans);
        return ans;
    }
}
