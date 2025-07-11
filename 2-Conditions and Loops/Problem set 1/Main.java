// // if condition
// public class Main{
//     public static void main(String[] args) {
//         int sal = 23000;
//         if (sal>20000) {
//             sal+=200;
//         }
//         else{
//             sal+=100;
//         }
//         System.out.println(sal);
//     }
// }


//while loop
// public class Main{
//     public static void main(String[] args) {
//         int num = 1;
//         while (num<=10) {
//             System.out.println("Hello World");
//             num++;
//         }
//     }
// }

//largest in three numbers
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first number : ");
        int a = sc.nextInt();
        
        System.out.println("enter second number : ");
        int b = sc.nextInt();
        System.out.println("enter third number : ");
        int c = sc.nextInt();
        if (a>b && a>c) {
            System.out.println("Largest number : " + a);
        }
        else if(b>a && b>c){
            System.out.println("Largest number : " + b);
            
        }
        else{
            System.out.println("Largest number : " + c);
            
        }
        sc.close();
    }
}