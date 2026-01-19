//LC 1248 Nice Subarrays

import java.util.HashMap;

class Solution {
    public int numberOfSubarrays(int[] a, int k) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int presum=0;
        int c=0;
        h.put(0,1);
        for(int i=0;i<a.length;i++){
            if(a[i]%2==0){
            presum+=0;
            }
            else{
                presum+=1;
            }
            if(h.containsKey(presum-k)){
                c+=h.get(presum-k);
            }
            h.put(presum,h.getOrDefault(presum,0)+1);
        }
        return c;
    }
}