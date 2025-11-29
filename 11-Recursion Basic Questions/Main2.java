//Factorial of a number

public class Main2 {
    public static void main(String[] args) {
        System.out.println(fact(30));
    }
    static int fact(int n){
        if(n<=1){
            return 1;
        }
        return n*fact(n-1);
    }
}