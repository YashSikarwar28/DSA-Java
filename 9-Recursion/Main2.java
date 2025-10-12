//printing first four number using recursion

public class Main2 {
    public static void main(String[] args) {
        num(1);
    }
    static void num(int n){
        System.out.println(n);
        num1(2);
    }
    static void num1(int n){
        System.out.println(n);
        num2(3);
    }
    static void num2(int n){
        System.out.println(n);
        num3(4);
    }
    static void num3(int n){
        System.out.println(n);
    }
}
