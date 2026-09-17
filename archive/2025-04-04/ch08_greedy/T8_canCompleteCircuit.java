package org.review2025spring.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/4 22:17
 * @comment
 */
public class T8_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin  = 0;
        int currSum =  0;
        int totalSum = 0;
        for (int i  = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            currSum += gas[i] - cost[i];
            if (currSum < 0) {   // 当前累加rest[i]和 curSum一旦小于0
                begin = i + 1;  // 起始位置更新为i+1
                currSum = 0;     // curSum从0开始
            }
        }
        if (totalSum < 0) return -1; // 说明怎么走都不可能跑一圈了
        return begin;
    }
}
