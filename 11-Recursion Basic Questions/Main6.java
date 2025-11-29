//palindrome number

public class Main6 {
    static int palin(int n){
        int dig=(int)(Math.log10(n))+1;
        return helper(n,dig);
    }
    private static int helper(int n,int dig){
        if (n%10 == n) {
            return n;
        }
        int rem=n%10;
        return rem*(int)(Math.pow(10, dig-1)) + helper(n/10, dig-1);
    }
    public static void main(String[] args) {
        int n=121;
        System.out.println(palin(n)==n);
    }
}
