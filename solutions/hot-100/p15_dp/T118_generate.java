/**
 * Practice template for:
 * - 118. Pascal's Triangle
 *   https://leetcode.cn/problems/pascals-triangle/
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 14:02
 * @comment
 */
public class T118_generate {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < numRows; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows - i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < numRows; k++) {
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i <= k; i++) {
                line.add(dp[i][k - i]);
            }
            ans.add(line);
        }
        return ans;
    }
}
