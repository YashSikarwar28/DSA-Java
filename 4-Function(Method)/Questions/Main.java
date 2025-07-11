// check prime number program

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         boolean a = isPrime(n);
         if(a==true){
            System.out.println(a);
            System.out.println(n+" is a prime number");
         }
         else{
            System.out.println(a);
            System.out.println(n+" is not a prime number");
         }
        sc.close();
    }
    static boolean isPrime(int n){
         if(n<=1){
            return false;
         }
         for(int i =2; i<n; i++) {
             if(n%i==0){
                return false;
             
            }
        }
        return true;
}}

// import java.util.Scanner;

// public class Main {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n  = sc.nextInt();
//         int original = n;
//         int temp=0;
//         while(n>0){
//             int rem = n%10;
//             n=n/10;
//             temp=temp+rem*rem*rem;
//         }
//         if (temp==original) {
//             System.out.println("Armstrong");
//         }
//         else{
//             System.out.println("Not armstrong");
//         }
//         sc.close();
//     }
// }
