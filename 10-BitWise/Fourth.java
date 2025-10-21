//to get how mant binary digits are there in the number

// public class Fourth {
//     public static void main(String[] args) {
//         int n=12;
//         int c=0;
//         while(n>0){
//             int last=n & 1; 
//             n =n >> 1;
//             c++;
//         }
//         System.out.println(c);
//     }
// }


//using formula 

public class Fourth {

    public static void main(String[] args) {
        int n=34;
        int b=2;
        int ans=(int)(Math.log(n)/Math.log(b)) +1;
        System.out.println(ans);
    }
}