package org.review2024summer.array;

public class T6_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int idx = 1;
        for (int loop = 1; loop <= n / 2; loop++) {
            int i = loop - 1, j = loop - 1;

            while (j++ < n - loop)
                res[i][j] = idx++;
            while (i++ < n - loop)
                res[i][j] = idx++;
            while (j-- > loop - 1)
                res[i][j] = idx++;
            while (i-- > loop - 1)
                res[i][j] = idx++;
        }
        if (n % 2 == 1)
            res[n/2][n/2] = idx;
        return res;
    }
}
