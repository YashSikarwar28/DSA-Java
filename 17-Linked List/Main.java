public class Main {
    public static void main(String[] args) {

        //Singly Linked List
        // Main1 list = new Main1();
        // list.insert(5);
        // list.insert(2);
        // list.insert(9);
        // list.insert(7);

        // list.insertLast(99);

        // list.insertPar(45, 2);
        // list.display();

        // System.out.println(list.delete());

        // System.out.println(list.delete_last());
        // list.display();

        // System.out.println(list.del_ind(1));
        // list.display();

        //Doubly Linked List
        // Main2 doubly=new Main2();
        // doubly.InsertFirst(2);
        // doubly.InsertFirst(5);
        // doubly.InsertFirst(9);
        // doubly.InsertFirst(7);

        // doubly.insertLast(50);

        // doubly.insertBetween(5,13);

        // doubly.display();

        //Circular Linked List
        Main3 circular=new Main3();
        circular.insert(20);
        circular.insert(12);
        circular.insert(6);
        circular.insert(35);

        circular.delete(6);

        circular.display();
    }
}