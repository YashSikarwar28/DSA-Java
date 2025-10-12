//Infinite Recursion

// public class Main3 {
//     public static void main(String[] args) {
//         print(1);
//     }
//     static void print(long n){
//         System.out.println(n);
//         print(n+1);
//     }
// }


public class Main3 {
    public static void main(String[] args) {
        print(0);
    }
    static void print(int n){
        if (n==5) { 
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n+1);
    }
}