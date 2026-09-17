/**
 * Practice template for:
 * - 560. Subarray Sum Equals K
 *   https://leetcode.cn/problems/subarray-sum-equals-k/
 */
import java.util.HashMap;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/06 17:56
 * @comment
 */
public class T560_subarraySum {
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
