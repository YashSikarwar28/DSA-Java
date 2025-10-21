//To calculate power of a number

public class Sixth {
    public static void main(String[] args) {
        int n=3;
        int p=6;
        int a=1;
        while (p>0) {
            if ((p&1)==1) {
                a*=n;
            }
            n*=n;
            p=p>>1;
        }
        System.out.println(a);
    }
}
