package org.review2025springAgain.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/4 22:17
 * @comment
 */
public class T8_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = 0;
        int totalGas = 0, currGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (currGas < 0) {
                begin = i + 1;
                currGas = 0;
            }
        }
        return totalGas < 0 ? -1 : begin;
    }
}
