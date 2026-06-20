//There are many solutions for this qustion but i did using this

class Solution {
    public int singleNumber(int[] a) {
        Arrays.sort(a);
        for(int i=1;i<a.length;i+=3){
            if(a[i]!=a[i-1]) return a[i-1];
        }
        return a[a.length-1];
    }
}