//Sieve of Eratosthenes - To print all the prime numbers upto a given range with the best time compexity
//assign a boolean array of n+1 size if a value is true in arr then all its multiple will become false and for marking false we will start the loop from i*i, in the end run a loop thorugh the array and all the true value print them.
import java.util.*;
public class Main {
    public static void main(String[] args) {
      int n=300;
      boolean[] arr=new boolean[n+1];
      Arrays.fill(arr,true);
      for(int i=2;i<Math.sqrt(n);i++){
        if(arr[i]){
          for(int j=i*i;j<=n;j+=i){
            arr[j]=false;
          }
        }
      }
      for(int i=2;i<=n;i++){
        if(arr[i]){
          System.out.print(i + " ");
        }
      }
    }
}
