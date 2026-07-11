//Go to each node and store index, its basically traversing + storing index of each node. Then subtract the 2 nodes which are at the maximum distance.


class Solution {
    class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> dq=new ArrayDeque<>();
        dq.offerLast(new Pair(root,0));
        int max=0;
        while(!dq.isEmpty()){
            int size=dq.size();
            long left=dq.peekFirst().index;
            long right=dq.peekLast().index;
            max=Math.max(max,(int)(right-left+1));
            for(int i=0;i<size;i++){
                Pair curr=dq.pollFirst();
                TreeNode node=curr.node;
                int ind=(int)curr.index;
                if(node.left!=null){
                    dq.offerLast(new Pair(node.left,2*ind+1));
                }
                if(node.right!=null){
                    dq.offerLast(new Pair(node.right,2*ind+2));
                }
            }
        }
        return max;
    }
}
