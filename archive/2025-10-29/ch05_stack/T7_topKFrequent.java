package org.review2025autumn.ch05_stack;

import java.util.HashMap;
import java.util.PriorityQueue;

public class T7_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((key1, key2) -> map.get(key1) - map.get(key2));
        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
