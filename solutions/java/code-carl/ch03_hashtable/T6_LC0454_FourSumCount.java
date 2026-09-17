/**
 * Practice template for:
 * - LeetCode 454. 4Sum II
 *   https://leetcode.cn/problems/4sum-ii/
 */
import java.util.HashMap;

public class T6_LC0454_FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int sum = n1 + n2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int sum = n3 + n4;
                if (map.containsKey(-sum)) {
                    res += map.get(-sum);
                }
            }
        }

        return res;
    }
}
