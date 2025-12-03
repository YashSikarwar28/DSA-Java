//check if the array is sorted or not

public class Main {
    static boolean sorted(int[] a,int i){
        if(i==a.length-1){
            return true;
        }
        return a[i]<a[i+1] && sorted(a, i+1);
    }
    public static void main(String[] args) {
        int[] a={1,2,3,7,5,6};
        System.out.println(sorted(a, 0));
    }
}