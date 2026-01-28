public class Main {

    private Node head;
    private Node tail;
    private int size;

    public Main() {
        this.size = 0;
    }

    // Inserting using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    // removing duplicates
    public void duplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // Merge Sorted List
    public static Main merge(Main first, Main second) {
        Node i = first.head;
        Node j = second.head;
        Main val = new Main();
        while (i != null && j != null) {
            if (i.value < j.value) {
                val.insert(i.value);
                i = i.next;
            } else {
                val.insert(j.value);
                j = j.next;
            }
        }
        while (i != null) {
            val.insert(i.value);
            i = i.next;
        }
        while (j != null) {
            val.insert(j.value);
            j = j.next;
        }
        return val;
    }

    // LL cycle - LeetCode style
    
    // public void cycle(){
    // Node node=new node;
    // Node fast=head;
    // Node slow=head;
    // while (fast!=null && fast.next!=null) {
    // fast=fast.next.next;
    // slow=fast.next;
    // if (fast==slow) {
    // return true;
    // }
    // }
    // return false;
    // }

    // Length of LL cycle
    public int lengthCycle(Node head) {
        Node slow = head;
        Node fast = head;
        int c = 0;
        while (fast != null && fast.next != null) {
            fast = head.next.next;
            slow = head.next;
            if (fast == slow) {
                Node temp = slow;
                // we must run the loop atleast once to calculate the length
                do {
                    temp = temp.next;
                    c++;
                } while (temp != slow);
                return c;
            }
        }
        return c;
    }

    // Happy Number - When you will see this question it will not click that you can
    // do this using a LL and cycle pattern.
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = square(n);
            fast = square(square(n));
        } while (slow != fast);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int square(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n = n / 10;
        }
        return ans;
    }

    // Middle of a LL
    public Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reversing a LL - In Place Reversal
    public void reverse(){
        if(size<2){
            return;
        }
        Node prev=null;
        Node pres=head;
        Node next=pres.next;

        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            while (next!=null) {
                next=next.next;
            }
        }
        head=prev;
    }
    
    //Palindrome Linked List - go to the middle then reverse the part after middle and compare it with the first half
    class Solution {
    static ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode node=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=reverse(slow.next);
        ListNode first=head;
        ListNode second=temp;
        while(second!=null){
            if(first.val!=second.val){
                slow.next=reverse(temp);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        slow.next=reverse(temp);
        return true;
    }
}

    public static void main(String[] args) {
        // Main ll=new Main();
        // ll.insert(1);
        // ll.insert(1);
        // ll.insert(1);
        // ll.insert(2);
        // ll.insert(3);
        // ll.insert(3);
        // ll.display();
        // ll.duplicates();
        // ll.display();

        Main first = new Main();
        Main second = new Main();
        first.insert(2);
        first.insert(6);
        first.insert(7);
        second.insert(3);
        second.insert(5);
        second.insert(9);

        Main ans = Main.merge(first, second);
        ans.display();
    }

    // inserting in LL
    public void insert(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // display
    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("END");
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
