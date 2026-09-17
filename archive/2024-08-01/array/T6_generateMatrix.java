package org.rereview2024summer.array;

public class T6_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int maxLoop = n / 2;
        int k = 1;
        for (int loop = 1; loop <= maxLoop; loop++) {
            int i = loop - 1, j = loop - 1;
            for ( ; j < n - loop; j++)
                res[i][j] = k++;
            for ( ; i < n - loop; i++)
                res[i][j] = k++;
            for ( ; j > loop - 1; j--)
                res[i][j] = k++;
            for ( ; i > loop - 1; i--)
                res[i][j] = k++;
        }
        if (n % 2 == 1) {
            res[maxLoop][maxLoop] = k;
        }

        return res;
    }
}
