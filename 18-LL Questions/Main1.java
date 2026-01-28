public class Main1 {
    public static void main(String[] args) {
        Main ll=new Main();
        ll.insert(20);
        ll.insert(12);
        ll.insert(4);
        ll.insert(28);
        ll.display();
        
        ll.insertRec(2, 1);

        ll.display();
    }
}
