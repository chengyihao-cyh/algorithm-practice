package org.rereview2024summer.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T7_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        // step1   build map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // step2   build heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((pair1, pair2) -> pair1.getValue() - pair2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else if (entry.getValue() > heap.peek().getValue()) {
                heap.poll();
                heap.offer(entry);
            }
        }

        // step3   build int[] res
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = heap.poll().getKey();
        return res;
    }
}
