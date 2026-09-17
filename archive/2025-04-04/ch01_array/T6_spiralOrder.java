package org.review2025spring.ch01_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T6_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>(n * m);
        int round = Math.min(n, m) / 2;

        for (int r = 0; r < round; r++) {
            for (int j = r; j < m - 1 - r; j++)
                res.add(matrix[r][j]);
            for (int i = r; i < n - 1 - r; i++)
                res.add(matrix[i][m - 1 - r]);
            for (int j = m - 1 - r; j > r; j--)
                res.add(matrix[n - 1 - r][j]);
            for (int i = n - 1 - r; i > r; i--)
                res.add(matrix[i][r]);
        }

        if (Math.min(n, m) % 2 == 1) {
            if (m > n) {
                // 补充行
                for (int j = round; j <= m - 1 - round; j++) {
                    res.add(matrix[round][j]);
                }
            } else {
                // 补充列
                for (int i = round; i <= n - 1 - round; i++) {
                    res.add(matrix[i][round]);
                }
            }
        }

        return res;
    }
}
