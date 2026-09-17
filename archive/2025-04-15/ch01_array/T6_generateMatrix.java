package org.review2025springAgain.ch01_array;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;

public class T6_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int round = n / 2;
        int k = 1;
        for (int r = 0; r < round; r++) {
            for (int j = r; j < n - 1 - r; j++)
                res[r][j] = k++;
            for (int i = r; i < n - 1 - r; i++)
                res[i][n - 1 - r] = k++;
            for (int j = n - 1 - r; j > r; j--)
                res[n - 1 - r][j] = k++;
            for (int i = n - 1 - r; i > r; i--)
                res[i][r] = k++;
        }
        if (n % 2 == 1) res[n / 2][n / 2] = k++;
        return res;
    }
}
