//I did using hashmap, will update bit manipulation code 

class Solution {
    public int[] singleNumber(int[] a) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<a.length;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        //ArrayList<Integer> arr=new ArrayList<>();
        int[] arr=new int[2];
        int j=0;
        for(int i:h.keySet()){
            if(h.get(i)==1){
                arr[j]=i;
                j++;
            }
        }
        return arr;
    }
}