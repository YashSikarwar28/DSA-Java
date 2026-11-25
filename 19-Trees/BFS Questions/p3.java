//LC 103 Zigzag printing using deque and BFS

//The main thing to notice here is when the nodes will be reversed and when not, when i=0 the nodes will go normally from left to right otherwise from right to left. 
//We will use deque as we can add from bith sides and remove as well
//When i=0,2,4... the nodes will go from left to right use offerlast and when i=1,3,5... use offerfirst.
//The main thing to notice is the direction of nodes in which they will be printed.
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        int ind = 0; //for knowing which node 0,1,2...
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if (ind % 2 == 0) {
                    dq.offerLast(node.val);
                } else {
                    dq.offerFirst(node.val);
                }
                // if (i % 2 == 0) {
                //     dq.offerLast(node.val);
                // } else {
                //     dq.offerFirst(node.val);
                // }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            while (!dq.isEmpty()) {
                temp.add(dq.poll());
            }
            ans.add(new ArrayList<>(temp));
            ind++;
        }
        return ans;
    }
}




List<List<Integer>> str=new ArrayList<>();
        if(root==null) return str;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        boolean rev=false;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ds=new LinkedList<>();
            for(int i=0;i<size;i++){
                if(rev){
                TreeNode t=queue.pollLast();
                ds.add(t.val);
                if(t.right!=null) queue.addFirst(t.right);
                if(t.left!=null) queue.addFirst(t.left);
                }
                else{
                    TreeNode t=queue.pollFirst();
                    ds.add(t.val);
                    if(t.left!=null) queue.addLast(t.left);
                    if(t.right!=null) queue.addLast(t.right);
                }
            }
            rev=!rev;
            str.add(ds);
        }
        return str;
