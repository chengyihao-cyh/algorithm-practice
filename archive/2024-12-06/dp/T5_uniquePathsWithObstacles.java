package org.review2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 17:00
 * @comment
 */
public class T5_uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) return 0;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < m && obstacleGrid[0][j] != 1; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
