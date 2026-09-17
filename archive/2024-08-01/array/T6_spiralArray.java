package org.rereview2024summer.array;

public class T6_spiralArray {
    public int[] spiralArray(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return new int[0];
        int n = matrix[0].length;
        if (n == 0)
            return new int[0];

        int idx = 0;
        int[] res = new int[m * n];
        res[m * n - 1] = Integer.MAX_VALUE;
        int maxLoop = Math.min(m, n) / 2;

        for (int loop = 1; loop <= maxLoop; loop++) {
            int i = loop - 1, j = loop - 1;
            for ( ; j < n - loop; j++)
                res[idx++] = matrix[i][j];
            for ( ; i < m - loop; i++)
                res[idx++] = matrix[i][j];
            for ( ; j > loop - 1; j--)
                res[idx++] = matrix[i][j];
            for ( ; i > loop - 1; i--)
                res[idx++] = matrix[i][j];
        }

        if (res[n * m - 1] == Integer.MAX_VALUE) {
            int i = maxLoop, j = maxLoop;
            if (m > n) {
                for ( ; i < m - maxLoop; i++)
                    res[idx++] = matrix[i][j];
            } else if (m < n) {
                for ( ; j < n - maxLoop; j++)
                    res[idx++] = matrix[i][j];
            } else {
                res[idx++] = matrix[i][j];
            }
        }

        return res;
    }
}
