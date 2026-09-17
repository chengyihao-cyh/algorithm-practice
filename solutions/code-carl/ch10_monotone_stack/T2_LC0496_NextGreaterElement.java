/**
 * Practice template for:
 * - LeetCode 496. Next Greater Element I
 *   https://leetcode.cn/problems/next-greater-element-i/
 */
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 17:10
 * @comment
 */
public class T2_LC0496_NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[i] > deque.peek()) {
                Integer n = deque.pop();
                if (map.containsKey(n)) {
                    res[map.get(n)] = nums2[i];
                }
            }
            deque.push(nums2[i]);
        }

        return res;
    }
}
