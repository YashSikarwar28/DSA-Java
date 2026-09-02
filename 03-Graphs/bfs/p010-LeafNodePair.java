//Main thing is the conversion of tree into undirected graph take a note of it. Its like a default syntax so take a note of it.
//DFS version is also available in trees repo
class Solution {
    int ans=0;
    public void creategraph(TreeNode root,TreeNode parent,Map<TreeNode,List<TreeNode>> graph,List<TreeNode> leaves){
        if(root==null) return;
        graph.putIfAbsent(root,new ArrayList<>());
        if(root.left==null && root.right==null){
            leaves.add(root);
        }
        if(parent!=null){
            graph.get(root).add(parent);
            graph.get(parent).add(root);
        }
        creategraph(root.left,root,graph,leaves);
        creategraph(root.right,root,graph,leaves);
    }
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode,List<TreeNode>> graph=new HashMap<>();
        List<TreeNode> leaves=new ArrayList<>();
      
      //by default there is no parent so we will assign null
        creategraph(root,null,graph,leaves);

      //looping through leaf nodes
        for(int i=0;i<leaves.size();i++){
            TreeNode t=leaves.get(i);
            Queue<TreeNode> q=new LinkedList<>();
            Set<TreeNode> visited=new HashSet<>();
            q.add(t);
            visited.add(t);
            int level=0;
          
          //looping thorugh queue - bfs format
            while(!q.isEmpty() && level<=distance){
                int size=q.size();
                for(int j=0;j<size;j++){
                    TreeNode tt=q.poll();
                    if(leaves.contains(tt) && tt!=t){
                        ans++;
                    }
                    for(TreeNode neig:graph.get(tt)){
                        if(!visited.contains(neig)){
                            visited.add(neig);
                            q.add(neig);
                        }
                    }
                }
                level++;
            }
        }        
        return ans/2;
    }
}
