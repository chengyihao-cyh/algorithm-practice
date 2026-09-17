package org.learn2024spring.array.q3_matrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.generateMatrix(4,3);
//        Solution2 solution2 = new Solution2();
//        int [][]ints = new int[][]{};
//        solution2.spiralArray(ints);
    }
}

class Solution1 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        for (int loop = 1; loop <= n/2; loop++){
            int i = loop - 1;
            int j = loop - 1;
            for ( ; j < n - loop; j++)
                res[i][j] = count++;
            for ( ; i < n - loop; i++)
                res[i][j] = count++;
            for ( ; j > loop - 1; j--)
                res[i][j] = count++;
            for ( ; i > loop - 1; i--)
                res[i][j] = count++;
        }
        if (n % 2 == 1){
            res[n/2][n/2] = count;
        }
        return res;
    }

    public int[][] generateMatrix(int m,int n) {
        int[][] res = new int[m][n];
        int count = 1;
        int maxLoop = Math.min(m, n) / 2;
        for (int loop = 1; loop <= maxLoop; loop++){
            int i = loop - 1;
            int j = loop - 1;
            for ( ; j < n - loop; j++)
                res[i][j] = count++;
            for ( ; i < m - loop; i++)
                res[i][j] = count++;
            for ( ; j > loop - 1; j--)
                res[i][j] = count++;
            for ( ; i > loop - 1; i--)
                res[i][j] = count++;
        }

        if (res[maxLoop][maxLoop] == 0){
            int i = maxLoop;
            int j = maxLoop;
            if (m > n) {
                for ( ; i < m - maxLoop; i++)
                    res[i][j] = count++;
            }else if (n > m) {
                for ( ; j < n - maxLoop; j++)
                    res[i][j] = count++;
            }else {
                res[i][j]  =count++;
            }
        }

        return res;
    }
}

// Leetcode 146
class Solution2 {
    public int[] spiralArray(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int count = 0;
        int maxLoop = Math.min(m, n) / 2;

        res[m * n - 1] = Integer.MAX_VALUE;



        for (int loop = 1; loop <= maxLoop; loop++){
            int i = loop - 1;
            int j = loop - 1;
            for ( ; j < n - loop; j++)
                res[count++] = matrix[i][j];
            for ( ; i < m - loop; i++)
                res[count++] = matrix[i][j];
            for ( ; j > loop - 1; j--)
                res[count++] = matrix[i][j];
            for ( ; i > loop - 1; i--)
                res[count++] = matrix[i][j];
        }

        if (res[m * n - 1] == Integer.MAX_VALUE){
            int i = maxLoop;
            int j = maxLoop;
            if (m > n) {
                for ( ; i < m - maxLoop; i++)
                    res[count++] = matrix[i][j];
            }else if (n > m) {
                for ( ; j < n - maxLoop; j++)
                    res[count++] = matrix[i][j];
            }else {
                res[count++] = matrix[i][j];
            }
        }

        return res;

    }
}



class Solution3 {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int maxLoop = Math.min(m, n) / 2;
        
        for (int loop = 1; loop <= maxLoop; loop++){
            int i = loop - 1;
            int j = loop - 1;
            for ( ; j < n - loop; j++)
                res.add(matrix[i][j]);
            for ( ; i < m - loop; i++)
                res.add(matrix[i][j]);
            for ( ; j > loop - 1; j--)
                res.add(matrix[i][j]);
            for ( ; i > loop - 1; i--)
                res.add(matrix[i][j]);
        }

        if (res.size() != m * n){
            int i = maxLoop;
            int j = maxLoop;
            if (m > n) {
                for ( ; i < m - maxLoop; i++)
                    res.add(matrix[i][j]);
            }else if (n > m) {
                for ( ; j < n - maxLoop; j++)
                    res.add(matrix[i][j]);
            }else {
                res.add(matrix[i][j]);
            }
        }
        return res;
    }
}










