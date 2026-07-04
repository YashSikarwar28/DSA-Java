//Morris Inorder Traversal - GFG

//If a left node exist then go to the rightmost node of that left node and then connect the rightmost node with the root node and then move the left pointer to next left node
//If left node does not exist go towards right

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.data);
                curr=curr.right;
            }else{
                Node temp=curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp=temp.right;
                }
                if(temp.right==null){
                    temp.right=curr;
                    curr=curr.left;
                }else{
                    temp.right=null;
                    ans.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
}
