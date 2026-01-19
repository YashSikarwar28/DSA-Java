//Doubly Linked List

public class Main2 {

    private Node head;

    //Inserting at first position
    public void InsertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if (head!=null) {
            head.prev=node;
        }
        head=node;
    }
    
    //Printing the LL from front and reverse
    public void display(){
        Node node=head;
        Node last=null;
        //Printing normally from first to last
        while (node!=null) {
            System.out.print(node.val + "-->");
            last=node;
            node=node.next;
        }
        System.out.println("End");

        //Printing in reverse
        System.out.println("Reverse Printing");
        while (last!=null) {
            System.out.print(last.val + "-->");
            last=last.prev;
        }
        System.out.println("END");
    }

    //Inserting at last
    public void insertLast(int val){
        Node node=new Node(val);
        Node last=head;
        node.next=null;

        if(head==null){
            node.prev=null;
            head=node;
            return;
        }
        
        while (last.next!=null) {
            last=last.next;
        }
        last.next=node;
        node.prev=last;
    }

    //inserting in between
    public void insertBetween(int after,int val){
        Node n=head;
        while (n!=null && n.val!=after) {
            n=n.next;
        }
        Node node=new Node(val);
        node.next=n.next;
        node.prev=n;
        if (n.next!=null) {
            n.next.prev=node;
        }
        n.next=node;
    }

    //basic structure of a Doubly Linked List
    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next,Node prev){
            this.val=val;
            this.next=next;
            this.prev=prev;
        }
    }
}
