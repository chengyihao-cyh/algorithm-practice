package org.rereview2024summer.array;

import java.util.ArrayList;
import java.util.List;

public class T6_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;

        int m = matrix.length;
        int n = matrix[0].length;
        int maxLoop = Math.min(m, n) / 2;

        for (int loop = 1; loop <= maxLoop; loop++) {
            int i = loop - 1, j = loop - 1;
            for ( ; j < n - loop; j++)
                res.add(matrix[i][j]);
            for ( ; i < m - loop; i++)
                res.add(matrix[i][j]);
            for ( ; j > loop - 1; j--)
                res.add(matrix[i][j]);
            for ( ; i > loop - 1; i--)
                res.add(matrix[i][j]);
        }

        if (res.size() != m * n) {
            int i = maxLoop;
            int j = maxLoop;
            if (m > n) {
                for ( ; i < m - maxLoop; i++)
                    res.add(matrix[i][j]);
            } else if (m < n) {
                for ( ; j < n - maxLoop; j++)
                    res.add(matrix[i][j]);
            } else {
                res.add(matrix[i][j]);
            }
        }

        return res;
    }
}
