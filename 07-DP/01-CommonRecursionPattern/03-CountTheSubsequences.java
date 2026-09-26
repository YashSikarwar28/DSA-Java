import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a={1,2,1};
        int tar=2;
        ArrayList<Integer> ans=new ArrayList<>();
        System.out.println(check(a,tar,0,0));
    }
    private static int check(int[] a,int tar,int sum,int ind){
        if(ind==a.length){
            if(sum==tar) return 1;
            return 0;
        }
        int l=check(a,tar,sum+a[ind],ind+1);
        sum-=a[ind];
        int f=check(a,tar,sum,ind+1);
        return l+f;
    }
}
