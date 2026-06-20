//Number with power of 2 has only one set bit

class Solution {
    public boolean isPowerOfTwo(int n) {
       return n>0 && (n & (n-1))==0;
    }
}



// public class p1 {
//     public static void main(String[] args) {
//         int[] c={1,2};
//         int[] s={0,1};
//         int[] cost={1,1};
//         int l=1;
//         int budget=3;
//         int h=budget;
//         while(l<=h){
//             int mid=l+(h-l)/2;
//             if (check(mid,c,s,cost,budget)) {
//                 l=mid+1;
//             }else{
//                 h=mid-1;
//             }
//         }
//         System.out.println(h);
//     }
//         public static boolean check(int mid,int[] c,int[] s,int[] cost,int budget){
//         int cc=0;
//         for(int i=0;i<c.length;i++){
//             int ans=c[i]*mid;
//             int diff=ans-s[i];
//             int add=(diff>0)?diff*cost[i]:0;
//             cc+=add;
//         }
//         return cc<=budget;
//     }
// }