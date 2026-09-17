/**
 * Practice template for:
 * - 74. Search a 2D Matrix
 *   https://leetcode.cn/problems/search-a-2d-matrix/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 20:16
 * @comment
 */
public class T74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        throw new UnsupportedOperationException("TODO");
    }
}
