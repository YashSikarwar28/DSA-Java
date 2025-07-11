//basic calculator code

import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter yput choice");
        System.out.println("1=Addition");
        System.out.println("2=Subtraction");
        System.out.println("3=Multiplication");
        System.out.println("4=Divide");
        int n = sc.nextInt();
        if(n==1){
            System.out.println("You are performing addition");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = a+b;
            System.out.println(r);
        }
        if(n==2){
            System.out.println("You are performing subtraction");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = a-b;
            System.out.println(r);
        }
        if(n==3){
            System.out.println("You are performing multiplication");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = a*b;
            System.out.println(r);
        }
        if(n==4){
            System.out.println("You are performing divison");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = a/b;
            System.out.println(r);
        }
        sc.close();
    }
}
