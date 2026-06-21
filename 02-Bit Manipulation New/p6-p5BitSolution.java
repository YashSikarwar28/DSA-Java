//xor all the number in array, we will get xor of 2 unique numbers in the array
//then take mask. mask = xor & (-xor)
//perform & operation on all array elements and if the bit is set put them in first group else second

class Solution {
    public int[] singleNumber(int[] a) {
        int xor=0;
        for(int i:a){
            xor^=i;
        }
        int mask=(xor) & (-xor);
        int first=0;
        int second=0;
        for(int i:a){   
            if((mask & i) !=0){
                first^=i;
            }else{
                second^=i;
            }
        }
        return new int[]{first,second};
    }
}