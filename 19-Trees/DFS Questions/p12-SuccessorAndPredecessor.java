class Solution {
        Node max=null;
        Node min=null;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> arr=new ArrayList<>();
        succ(root,key);
        pred(root,key);
        arr.add(min);
        arr.add(max);
        return arr;
    }
    private void succ(Node root, int key){
        if(root==null) return;
        if(root.data>key){
            max=root;
            succ(root.left,key);
        }else{
            succ(root.right,key);
        }
    }
    private void pred(Node root, int key){
        if(root==null) return;
        if(root.data<key){
            min=root;
            pred(root.right,key);
        }else{
            pred(root.left,key);
        }
    }
}
