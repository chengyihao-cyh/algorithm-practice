/**
 * Practice template for:
 * - LeetCode 134. Gas Station
 *   https://leetcode.cn/problems/gas-station/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/4 22:17
 * @comment
 */
public class T8_LC0134_CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas = 0;
        int totalGas = 0;
        int begin = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                begin = i + 1;
                currGas = 0;
            }
        }
        return totalGas < 0 ? -1 : begin;
    }
}
