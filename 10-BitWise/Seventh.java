//number raised to power

public class Seventh {
    public static void main(String[] args) {
        int a=3;
        int b=6;
        int c=1;
        while (b>0) {
            if ((b & 1)==1) {
                c*=a;
            }
            a*=a;
            b=b>>1;
        }
        System.out.println(c);
    }
}
