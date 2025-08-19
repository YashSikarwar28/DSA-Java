// public class Digits {

//     public static void main(String[] args) {
//         int[][] a = {
//                 { 1, 8, 3 }, { 3, 2, 1 }, {6,4,4}
//         };
//         int max = 0;
//         for (int i = 0; i < a.length; i++) {
//             int c = 0;
//             for (int j = 0; j < a[i].length; j++) {
//                 c+=a[i][j];
//             }
//             if (c>max) {
//                 max=c;
//             }
//         }
//         System.out.println(max);
//     }
// }


class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i=0;i<accounts.length;i++){
            int c = 0;
            for(int j=0;j<accounts[i].length;j++){
                c+=accounts[i][j];
            }
            if(c>max){
                max=c;
            }
        }
        return max;
    }
}