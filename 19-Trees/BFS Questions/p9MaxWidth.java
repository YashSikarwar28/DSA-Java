//Go to each node and store index, its basically traversing + storing index of each node. Then subtract the 2 nodes which are at the maximum distance.
//To prevent overflow we will take the min of i at each level and subtract the level from it.


class Solution {
    class Pair{
        TreeNode node;
        long num;
        Pair(TreeNode node,long num){
            this.node=node;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            long min=q.peek().num;
            long fir=0,last=0;
            for(int i=0;i<size;i++){
                long ind=q.peek().num-min;
                TreeNode t=q.peek().node;
                q.poll();
                if(i==0) fir=ind;
                if(i==size-1) last=ind;
                if(t.left!=null){
                    q.add(new Pair(t.left,ind*2+1));
                }
                if(t.right!=null){
                    q.add(new Pair(t.right,ind*2+2));
                }
            }
            ans=Math.max(ans,(int)(last-fir+1));
        }
        return ans;
    }
}