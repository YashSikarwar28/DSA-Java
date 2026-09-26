//We will take a boolean variable if we find the subsequence we will print it and return true otherwise return false, will follow the same structure as in previous question.
//The main thing is adding a boolean check to avoid further recursion calls.
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a={1,2,1};
        int tar=2;
        ArrayList<Integer> ans=new ArrayList<>();
        check(a,tar,0,ans,0);
    }
    private static boolean check(int[] a,int tar,int sum,ArrayList<Integer> ans,int ind){
        if(ind==a.length){
            if(sum==tar){
                for(int i:ans){
                    System.out.print(i);
                }
                return true;
            }
            return false;
        }
        ans.add(a[ind]);
        if(check(a,tar,sum+a[ind],ans,ind+1)){
            return true;
        }
        ans.remove(ans.size()-1);
        if(check(a,tar,sum,ans,ind+1)){
            return true;
        }
        return false;
    }
}
