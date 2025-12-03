//Rotated Binary Search

public class Main5 {

    static int bs(int[] a, int s, int e, int tar) {
        int mid = s + (e - s) / 2;
        if (s > e) {
            return -1;
        }
        if (a[mid]==tar) {
            return mid;
        }
        if (a[s] <= a[mid]) {
            if (tar >= a[s] && tar <= a[mid]) {
                return bs(a, s, mid-1, tar);
            }
            else{
                return bs(a, mid+1, e, tar);
            }
        }
        if (tar>=a[mid] && tar<=a[e]) {
            return bs(a, mid+1, e, tar);
        }
        else{
            return bs(a, s, mid-1, tar);
        }
    }

    public static void main(String[] args) {
        int[] a={5,6,7,8,9,1,2,3};
        System.out.println(bs(a, 0, a.length-1, 2));
    }
}