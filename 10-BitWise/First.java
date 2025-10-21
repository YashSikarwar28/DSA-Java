//Even or Odd using AND function

public class First {
    public static void main(String[] args) {
        System.out.println(EvenOdd(15));
    }
    static boolean EvenOdd(int n){
        return (n & 1)==1;
    }
}
