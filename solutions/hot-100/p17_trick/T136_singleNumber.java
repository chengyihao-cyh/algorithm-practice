/**
 * Practice template for:
 * - 136. Single Number
 *   https://leetcode.cn/problems/single-number/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/8 20:19
 * @comment
 */
public class T136_singleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
