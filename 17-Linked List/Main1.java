//Count the subarray wih sum K

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> seen=new HashMap<>();
        seen.put(0,1);
        int c=0;
        int presum=0;
        for(int i:nums){
            presum+=i;
            if(seen.containsKey(presum-k)){
                c+=seen.get(presum-k);
            }
            seen.put(presum,seen.getOrDefault(presum,0)+1);
        }
        return c;
    }
}


//Longest subarray with sum K

// import java.util.HashMap;

// public class Main1 {
//     public static void main(String[] args) {
//         HashMap<Integer,Integer> seen=new HashMap<>();
//         int res=0;
//         int presum=0;
//         int[] a={1,1,1};
//         int k=2;
//         for(int i=0;i<a.length;i++){
//             presum+=a[i];
//             if (seen.containsKey(presum-k)) {
//                 res=Math.max(res,i-seen.get(presum-k));
//             }
//             if (!seen.containsKey(presum)) {
//                 seen.put(presum, i);
//             }
//         }
//         System.out.println(res);
//     }
// }
