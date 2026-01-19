// Circular Linked List
public class Main3 {

    private Node head;
    private Node tail;

    public Main3() {
        this.head = null;
        this.tail = null;
    }

    // Inserting
    public void insert(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    //Deleting
    public void delete(int val){
        Node node=head;
        if(node==null){
            return;
        }
        if (node.val==val) {
            head=head.next;
            tail.next=head;
            return;
        }

        do{
            Node n=node.next;
            if(n.val==val){
                node.next=n.next;
                break;
            }
            node=node.next;
        }
        while(node!=head);
    }

    // Displaying a CLL
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node node = head;
        do {
            System.out.print(node.val + " -> ");
            node = node.next;
        } while (node != head);

        System.out.println("back to head");
    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}