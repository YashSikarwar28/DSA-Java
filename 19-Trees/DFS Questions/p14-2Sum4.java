//We will have a rev which act like 2 pointer for a typical 2 sum problem. When its true we go towards right finding the max and when false we go towards left finding the min following with the iterator approach. Take a look at the syntax as it is a bit complicated.

public class iterator{
    private Stack<TreeNode> st=new Stack<>();
    boolean rev;
    public iterator(TreeNode root,boolean rev){
        this.rev=rev;
        pushall(root);
    }
    public boolean hasnext(){
        return !st.isEmpty();
    }
    public int next(){
        TreeNode t=st.pop();
        if(rev){
            pushall(t.left);
        }else{
            pushall(t.right);
        }
        return t.val;
    }
    private void pushall(TreeNode root){
        while(root!=null){
            st.push(root);
            if(rev){
                root=root.right;
            }else{
                root=root.left;
            }
        }
    }
 }

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        iterator l=new iterator(root,false);
        iterator r=new iterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            if(i+j==k) return true;
            if(i+j<k){
                i=l.next();
            }else{
                j=r.next();
            }
        }
        return false;
    }
}
