// if we dont know the size of array and we want to add as many numbers as possible according to our wish there we use arraylist concept.

import java.util.ArrayList;
import java.util.Scanner;

public class MyArrayList {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        //initialisation
        // add element
        // list.add(45);
        // list.add(54);
        // list.add(4);
        
        // System.out.println(list);
        // list.set(0,12);
        // list.remove(2);
        
        Scanner sc = new Scanner(System.in);
        
        // for (int i = 0; i < 5; i++) {
            //     list.add(sc.nextInt());
            // }
            
            // System.out.println(list.get(1));
            
            // System.out.println(list);
            // sc.close();
            for (int i = 0; i < 3; i++) {
                arr.add(new ArrayList<>(i));
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr.get(i).add(sc.nextInt());
                }
            }
            System.out.println(arr);

            sc.close();
    }
}
