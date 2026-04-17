//LC 116 Population next right pointer - LinkedList + BFS All about visualization and nodes connecting knowldege 

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Node curr=root;
        while(curr.left!=null){
            Node temp=curr.left;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next==null){
                    curr.right.next=null;
                }
                else{
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            curr=temp;
        }
        return root;
    }
}