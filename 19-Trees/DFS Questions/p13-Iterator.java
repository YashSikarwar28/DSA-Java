//Go to complete left push into stack then go to right and push into stack

class BSTIterator {
    private Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    public int next() {
        TreeNode t=st.pop();
        push(t.right);
        return t.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void push(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

}
