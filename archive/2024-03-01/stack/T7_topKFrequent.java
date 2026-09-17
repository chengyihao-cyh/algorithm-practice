package org.learn2024spring.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T7_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        int[] res = new int[k];

        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k){
                priorityQueue.offer(new Integer[]{entry.getKey(), entry.getValue()});
            } else if (entry.getValue() > priorityQueue.peek()[1]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new Integer[]{entry.getKey(), entry.getValue()});
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll()[0];
        }

        return res;
    }
}
