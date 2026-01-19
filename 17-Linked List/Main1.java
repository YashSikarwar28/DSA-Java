//Singly Linked List

public class Main1 {

    private Node head;
    private Node tail;
    private int size;

    public Main1() {
        this.size = 0;
    }

    // inserting a node
    public void insert(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        // if there is only one element head=tail
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // display linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // insert at last
    public void insertLast(int val) {

        if (tail == null) {
            insert(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // insert at a particular position
    public void insertPar(int val, int ind) {
        if (ind == 0) {
            insert(val);
            return;
        }
        if (ind == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    // deleting the first element
    public int delete() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    // deleting the last element
    public int delete_last() {

        if (size<=1) {
            delete(); //delete first element itself
        }

        Node node=head;
        for(int i=1;i<size-1;i++){
            node=node.next;
        }
        int val=tail.value;
        tail=node;
        tail.next=null;
        size--;
        return val;
        // if (size <= 1) {
        //     return delete();
        // }
        // Node secondLast = get(size - 2);
        // int val = tail.value;
        // tail = secondLast;
        // tail.next = null;

        // return val;
    }

    // getting reference for a particular node
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    //deleting a particular index
    public int del_ind(int ind){
        if (ind==0) {
            return delete();
        }
        if (ind==size-1) {
            return delete_last();
        }
        Node node=head;
        for(int i=1;i<ind;i++){
            node=node.next;
        }
        int val=node.next.value;
        node.next=node.next.next;

        return val;
    }

    //finding a particular node for given index
    public Node find_node(int ind){
        if (ind==0) {
            return head;
        }
        if (ind==size-1) {
            return tail;
        }
        Node node=head;
        for(int i=0;i<ind;i++){
            node=node.next;
        }
        return node;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
