// import java.util.Scanner; // getting input from user

// public class Main{
//     public static void main(String[] args) {
//         System.out.println("Hello World!");
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter your roll no : ");
//         int rollNo = sc.nextInt();
//         System.out.println("Your roll no is : " + rollNo);
//         sc.close();
//     }
// }


//mulitplication table prog
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int sum=0;
    for (int i = 1; i <=10; i++) {
        sum = a*i;
        System.out.println(a+"*"+i+"="+sum);
    }
    sc.close();
}
}


