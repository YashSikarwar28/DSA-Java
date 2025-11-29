//to count number of zeros in a number

public class Main7 {
    static int count(int n){
        return helper(n,0);
    }
    private static int helper(int n,int c){
        if (n==0) {
            return c;
        }
        if (n%10==0) {
            return helper(n/10, c+1);
        }
        return helper(n/10, c);
    }
    public static void main(String[] args) {
        System.out.println(count(123004));
    }
}