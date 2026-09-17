package org.review2025spring.ch01_array;

import java.util.ArrayList;
import java.util.List;

public class T6_spiralArray {
    public int[] spiralArray(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[]{};
        int m = matrix[0].length;
        if (m == 0) return new int[]{};
        int[] res = new int[n * m];

        int k  = 0;
        int round = Math.min(n, m) / 2;

        for (int r = 0; r < round; r++) {
            for (int j = r; j < m - 1 - r; j++)
                res[k++] = matrix[r][j];
            for (int i = r; i < n - 1 - r; i++)
                res[k++] = matrix[i][m - 1 - r];
            for (int j = m - 1 - r; j > r; j--)
                res[k++] = matrix[n - 1 - r][j];
            for (int i = n - 1 - r; i > r; i--)
                res[k++] = matrix[i][r];
        }

        if (Math.min(n, m) % 2 == 1) {
            if (m > n) {
                // 补充行
                for (int j = round; j <= m - 1 - round; j++) {
                    res[k++] = matrix[round][j];
                }
            } else {
                // 补充列
                for (int i = round; i <= n - 1 - round; i++) {
                    res[k++] = matrix[i][round];
                }
            }
        }

        return res;
    }
}
