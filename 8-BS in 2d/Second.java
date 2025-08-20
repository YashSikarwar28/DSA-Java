class Solution {
    public boolean searchMatrix(int[][] a, int tar) {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return false;
        }
        return search(a, tar);
    }

    // Binary Search in a specific row
    boolean BS(int[][] a, int rs, int cs, int ce, int tar) {
        while (cs <= ce) {
            int mid = cs + (ce - cs) / 2;
            if (a[rs][mid] == tar) {
                return true;
            } else if (a[rs][mid] < tar) {
                cs = mid + 1;
            } else {
                ce = mid - 1;
            }
        }
        return false;
    }

    boolean search(int[][] a, int tar) {
        int rows = a.length;
        int cols = a[0].length;

        // If only one row, do binary search directly
        if (rows == 1) {
            return BS(a, 0, 0, cols - 1, tar);
        }

        int rstart = 0;
        int rend = rows - 1;
        int cmid = cols / 2;

        // Narrow down to 2 rows
        while (rstart < rend - 1) {
            int mid = rstart + (rend - rstart) / 2;

            if (a[mid][cmid] == tar) {
                return true;
            } else if (a[mid][cmid] < tar) {
                rstart = mid;
            } else {
                rend = mid;
            }
        }

        // Check the middle column of the two candidate rows
        if (a[rstart][cmid] == tar)
            return true;
        if (rstart + 1 < rows && a[rstart + 1][cmid] == tar)
            return true;

        // Search in 4 submatrices
        // 1st quadrant
        if (cmid - 1 >= 0 && tar <= a[rstart][cmid - 1]) {
            return BS(a, rstart, 0, cmid - 1, tar);
        }
        // 2nd quadrant
        else if (cmid + 1 < cols && tar >= a[rstart][cmid + 1] && tar <= a[rstart][cols - 1]) {
            return BS(a, rstart, cmid + 1, cols - 1, tar);
        }
        // 3rd quadrant
        else if (rstart + 1 < rows && cmid - 1 >= 0 && tar <= a[rstart + 1][cmid - 1]) {
            return BS(a, rstart + 1, 0, cmid - 1, tar);
        }
        // 4th quadrant
        else if (rstart + 1 < rows && cmid + 1 < cols) {
            return BS(a, rstart + 1, cmid + 1, cols - 1, tar);
        }

        return false;
    }
}
