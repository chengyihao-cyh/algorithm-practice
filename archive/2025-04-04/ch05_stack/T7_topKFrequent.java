package org.review2025spring.ch05_stack;

import java.util.*;

public class T7_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
/*        // 统计
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 建堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((key1, key2) -> map.get(key1) - map.get(key2));
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else {
                heap.remove();
                heap.add(key);
            }
        }

        // 输出
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.remove();
        }
        return null;*/

        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        int[] res = new int[k];
        for (Integer val : map.keySet()) {
            res[i++] = val;
            if (i == k)
                return res;
        }
        return null;
    }
}
