package org.review2024summer.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T7_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        int[] res = new int[k];

        // step1 build set
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // step2 build heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer frequency = entry.getValue();
            if (heap.size() < k) {
                heap.offer(new Integer[]{num, frequency});
            } else if (!heap.isEmpty() && frequency > heap.peek()[1]){
                heap.poll();
                heap.offer(new Integer[]{num, frequency});
            }
        }

        // step3 build int[] res
        for (int i = k - 1; i >=0; i--)
            res[i] = heap.poll()[0];

        return res;
    }
}
