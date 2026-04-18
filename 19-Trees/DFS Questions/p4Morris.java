//Morris Inorder Traversal - GFG

//If a left node exist then go to the rightmost node of that left node and then connect the rightmost node with the root node and then move the left pointer to next left node
//If left node does not exist go towards right

public ArrayList<Integer> inOrder(Node root) {
    ArrayList<Integer> a = new ArrayList<>();
    Node t = root;
    while (t != null) {
        if (t.left == null) {
            a.add(t.data);
            t = t.right;
        } else {
            Node l = t.left;
            while (l.right != null && l.right != t) {
                l = l.right;
            }
            if (l.right == null) {
                l.right = t;
                t = t.left;
            } else {
                l.right = null;
                a.add(t.data);
                t = t.right;
            }
        }
    }
    return a;
}