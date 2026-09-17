/**
 * Practice template for:
 * - LeetCode 739. Daily Temperatures
 *   https://leetcode.cn/problems/daily-temperatures/
 */
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 16:33
 * @comment
 */
public class T1_LC0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i  = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}
