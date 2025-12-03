//searching in an array

public class Main2 {
    static int find(int[] a,int i,int search){
        if (a[i]==search) {
            return i;
        }
        if (i==a.length-1) {
            return -1;
        }
        return find(a, i+1, search);
    }
    public static void main(String[] args) { 
        int[] a={1,2,3,4,5,6};
        System.out.println(find(a, 0, 6));
    }
}


