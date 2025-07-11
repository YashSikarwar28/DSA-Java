// import java.util.Scanner;

// public class Main{
    //     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         char ch = sc.next().trim().charAt(0);
//         if(ch>='a' && ch<='z'){
    //             System.out.println("Lower case");
//         }
//         else{
//             System.out.println("Upper case");
//         }
//         sc.close();
//     }
// }



//Fibonacci Series
// 0,1,1,2,3,5,8....


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 1;
        System.out.println("Enter the number : ");
        int c = sc.nextInt();
        for (int i = 0; i <= c; i++) {
            int sum = a+b;
            a=b;
            b=sum;
            System.out.print(b+" ");
        }
        sc.close();

    }
}