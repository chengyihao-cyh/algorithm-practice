package org.review2025autumn.ch01_array;

import java.util.ArrayList;
import java.util.List;

public class T6_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int round = Math.min(n, m) / 2;
        for (int r = 0; r < round; r++) {
            for (int j = r; j < m - r - 1; j++) res.add(matrix[r][j]);
            for (int i = r; i < n - r - 1; i++) res.add(matrix[i][m - r - 1]);
            for (int j = m - r - 1; j > r; j--) res.add(matrix[n - r - 1][j]);
            for (int i = n - r - 1; i > r; i--) res.add(matrix[i][r]);
        }
        if (Math.min(n, m) % 2 == 1) {
            if (m >= n) {
                // 1 line
                for (int j = round; j < m - round; j++) res.add(matrix[round][j]);
            } else {
                // 1 col
                for (int i = round; i < n - round; i++) res.add(matrix[i][round]);
            }
        }

        return res;
    }
}
