//Magic Number using BitWise 

public class Third {
    public static void main(String[] args) {
        int n=4;
        int ans=0;
        int base=5;
        while (n>0) {
            int last = n & 1;        //getting the last bit
            n=n >> 1;               //shifting the last bit in order to get the next bit
            ans+=last*base;        //multiplying it with 5 
            base=base * 5;        //increasing the mulitiple of 5
        }
        System.out.println(ans);
    }
}
