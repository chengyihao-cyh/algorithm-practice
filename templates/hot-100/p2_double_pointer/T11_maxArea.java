/**
 * Practice template for:
 * - 11. Container With Most Water
 *   https://leetcode.cn/problems/container-with-most-water/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/6 17:27
 * @comment
 */
public class T11_maxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int currSum = 0, maxSum = 0;
        while (l < r) {
            currSum = Math.min(height[l], height[r]) * (r - l);
            maxSum = Math.max(maxSum, currSum);
            if (height[l] < height[r]) {
                int currL = height[l];
                while (l < r && height[l] <= currL) {
                    l++;
                }
            } else {
                int currR = height[r];
                while (l < r && height[r] <= currR) {
                    r--;
                }
            }
        }
        return maxSum;
    }


    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int currSum = 0, maxSum = 0;
        while (l < r) {
            currSum = Math.min(height[l], height[r]) * (r - l);
            maxSum = Math.max(maxSum, currSum);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxSum;
    }
}
