//basic switch program 

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner("System.in");
//         String a = sc.next();
//         switch (a) {
//             case "Apple":
//             System.out.println("A sweet red fruit");
//             break;
//             case "Orange":
//             System.out.println("A round fruit");
//             break;
//             case "Grapes":
//             System.out.println("A small green fruit");
//             case "Mango":
//             System.out.println("King of fruits");
//             break;
//             default:
//                 System.out.println("Enter a valid fruit");
//         }
//         sc.close();
//     }
// }


//Enhanced version of switch statement
// import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String fruit = sc.next();

//         switch(fruit){
//             case "Mango" -> System.out.println("King of fruits");
//             case "Apple" -> System.out.println("A sweet red fruit");
//             case "Orange" -> System.out.println("A round fruit");
//             case "Grapes" -> System.out.println("A small green fruit");
//             default -> System.out.println("Invalid fruit entered");
//         }
//         sc.close();
//     }
// }

//nested switch
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int emp = sc.nextInt();
        String dep = sc.next();
        switch(emp){
            case 1 -> System.out.println("1st employee");
            case 2 -> System.out.println("2nd employee");
            case 3 -> {
                System.out.println("3rd emp");
                switch(dep){
                    case "IT" -> System.out.println("IT Dep");
                    case "cse" ->System.out.println("CSE Dep");
                    default -> System.out.println("No Dep"); 
                }
            }
        }
        sc.close();
    }
}