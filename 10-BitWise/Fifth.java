//To check whether the number is a power of 2 or not

// public class Fifth {
//     public static void main(String[] args) {
//         int n=14;
//         int c=0;
//         while (n>0) {
//             int ans=n & 1;
//             if (ans==1) {
//                 c++;
//             }
//             n=n>>1;
//         }
//         System.out.println(c);
//     }
// }


public class Fifth {
    public static void main(String[] args) {
        int n=6;
        boolean ans = (n & (n-1)) == 0;
        System.out.println(ans);
    }
}