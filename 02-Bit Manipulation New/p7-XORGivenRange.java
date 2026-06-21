//GFG

class Solution {
    public static int findXOR(int l, int r) {
        int a=l-1;
        return (xor(a)) ^ (xor(r));
    }
    private static int xor(int a){
        if(a%4==0) return a;
        else if(a%4==1) return 1;
        else if(a%4==2) return a+1;
        return 0;
    }
    private static int xor2(int r){
        if(r%4 == 0) return r;
        else if(r%4 == 1) return 1;
        else if(r%4 == 2) return r+1;
        else return 0;
    }
}