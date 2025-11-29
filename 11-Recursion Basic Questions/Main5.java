//reverse a number using a helper function 

public class Main5 {
    static int rev(int n) {
        // used to count number of digits
        int dig = (int) (Math.log10(n)) + 1;
        return helper(n, dig);
    }

    private static int helper(int n, int dig) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, dig - 1)) + helper(n / 10, dig - 1);
    }

    public static void main(String[] args) {
        System.out.println(rev(2345));
    }
}
