//1 hr : 18 min

import java.util.Scanner;

public class Main {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // insert element
    public void populate(Scanner scanner) {
        System.out.println("Enter a value : ");
        int value = scanner.nextInt();
        // creating root node
        root = new Node(value);
        populate(scanner, root);
    }

    // inserting in the left and right of the root node
    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left value of node");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter right of "+node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value you want to insert at right");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    //displaying the tree
    //indent string is just for giving space
    public void display() {
        display(this.root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left,indent+"\t");
        display(node.right, indent+"\t");
    }

    //pre order
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if (node==null) {
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    //in order
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node node){
        if (node==null) {
            return;
        }
        System.out.println("Left value" + node.left);
        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }
    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }
}