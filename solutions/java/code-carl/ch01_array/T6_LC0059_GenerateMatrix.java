/**
 * Practice template for:
 * - LeetCode 59. Spiral Matrix II
 *   https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class T6_LC0059_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int round = n / 2;
        int num = 1;
        for (int r = 0; r < round; r++) {
            for (int j = r; j < n - r - 1; j++) matrix[r][j] = num++;
            for (int i = r; i < n - r - 1; i++) matrix[i][n - r - 1] = num++;
            for (int j = n - r - 1; j > r; j--) matrix[n - r - 1][j] = num++;
            for (int i = n - r - 1; i > r; i--) matrix[i][r] = num++;
        }
        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = n * n;
        }
        return matrix;
    }
}
