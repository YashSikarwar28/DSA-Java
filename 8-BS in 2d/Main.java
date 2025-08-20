//row wise and coloumn wise sorted matrix

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] a = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 }
        };
        int tar = 33;
        int[] ans = search(a, tar);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] a, int tar) {
        int row = 0;
        int col = a.length - 1;

        while (row < a.length && col >= 0) {
            if (a[row][col] == tar) {
                return new int[] { row, col };
            } else if (a[row][col] < tar) {
                row++;
            } else {
                col--;
            }
        }
        return new int[] { -1, -1 };
    }
}
