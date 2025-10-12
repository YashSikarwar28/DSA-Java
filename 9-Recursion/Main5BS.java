//Binary Search using Recursion

public class Main5BS {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 22, 44, 78, 99 };
        int tar = 44;
        System.out.println(search(a, tar, 0, a.length - 1));
    }

    static int search(int[] a, int tar, int s, int e) {
        int m = s + (e - s) / 2;
        if (s > e)
            return -1;
        if (a[m] == tar)
            return m;
        if (tar < a[m]) {
            return search(a, tar, s, m - 1);
        }
        return search(a, tar, m + 1, e);
    }
}