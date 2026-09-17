/**
 * Practice template for:
 * - LeetCode 503. Next Greater Element II
 *   https://leetcode.cn/problems/next-greater-element-ii/
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 20:44
 * @comment
 */
public class T3_LC0503_NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < len * 2; i++) {
            while (!deque.isEmpty() && nums[i % len] > nums[deque.peek()]) {
                Integer idx = deque.pop();
                res[idx] = nums[i % len];

            }
            deque.push(i % len);
        }

        return res;
    }
}
