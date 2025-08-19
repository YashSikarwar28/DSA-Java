import java.util.Arrays;

public class SearchinRange {
    public static void main(String[] args) {
        int[][] arr = {
                { 45, 21, 87 },
                { 18, 63, 70 },
                { 52, 96, 44 }
        };
        int tar = 63;
        int[] ans = search(arr, tar);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr, int tar) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == tar) {
                    return new int[] { r, c };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
