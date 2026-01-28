// public class Main2 {
//     public static void main(String[] args) {
//         int n=4;
//         int count=0;
//         good(n,100,999,count);
//     }
//     static void good(int n,int ind,int end,int count){
//         if(ind==end){
//             System.out.println(count);
//             return;
//         }
//         String a=Integer.toString(ind);
//         boolean check=true;
//         for(int i=0;i<a.length();i++){
//             if(i%2==0 && (a.charAt(i)-'0')%2!=0){
//                 check=false;
//                 break;
//             }
//             if(i%2!=0 && !prime(a.charAt(i)-'0')){
//                 check=false;
//                 break;
//             }
//         }
//         if(check){
//             count++;
//         }
//         good(n,ind+1,end,count);
//     }
//     static boolean prime(int n){
//         if (n<=1) {
//             return false;
//         }
//         for(int i=2;i<=Math.sqrt(n);i++){
//             if (n%i==0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
