//Idea is simple either take the element or do not take it, take add to arraylist update the function call and remove from arraylist thats the bsaic waorkflow
//If not take update the function call and move to next index
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] a={1,2,1};
        int tar=2;
        ArrayList<Integer> ans=new ArrayList<>();
        check(a,tar,0,ans,0);
    }
    private static void check(int[] a,int tar,int sum,ArrayList<Integer> ans,int ind){
        if(ind==a.length){
        if(sum==tar){
            for(int i:ans){
                System.out.print(i);
            }
            System.out.println();
        }
            return;
        }
        //choosing the current element
        ans.add(a[ind]);
        check(a,tar,sum+a[ind],ans,ind+1);
        ans.remove(ans.size()-1);
        //not choosing the current element
        check(a,tar,sum,ans,ind+1);
    }
}
