//LeetCode 525

import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] a) {
        int res=0;
        int presum=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        h.put(0,-1);
        for(int i=0;i<a.length;i++){
            if(a[i]==1){
                presum+=1;
            }
            else{
                presum+=-1;
            }
            if(h.containsKey(presum)){
                res=Math.max(res,i-h.get(presum));
            }
            else{
                h.put(presum,i);
            }
            // if(!h.containsKey(presum)){
            //     h.put(presum,i);
            // }
        }
        return res;
    }
}



// import java.util.HashMap;

// public class Main2 {
//     public static void main(String[] args) {
//         int[] a={0,1,1,1,1,1,0,0,0};
//         int res=0;
//         int presum=0;
//         HashMap<Integer,Integer> h=new HashMap<>();
//         for(int i=0;i<a.length;i++){
//             if(a[i]==1){
//                 presum+=1;
//             }
//             else{
//                 presum+=-1;
//             }
//             if (presum==0) {
//                 res=i;
//             }
//             if (h.containsKey(presum)) {
//                 res=Math.max(res,i-h.get(presum));
//             }
//             if (!h.containsKey(presum)) {
//                 h.put(presum, i);
//             }
//         }
//         System.out.println(res);
//     }
// }