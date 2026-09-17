/**
 * Practice template for:
 * - LeetCode 70. Climbing Stairs
 *   https://leetcode.cn/problems/climbing-stairs/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/20 15:10
 * @comment
 */
public class T2_LC0070_ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prepre = 1, pre = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prepre + pre;
            prepre = pre;
            pre = curr;
        }
        return pre;
    }
}
