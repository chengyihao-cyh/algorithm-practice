package org.review2025autumn.ch05_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T6_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k - 1) {
                res[idx++] = queue.getMax();
                queue.remove(nums[i - k + 1]);
            }
        }

        return res;
    }

    public class MyQueue {
        Deque<Integer> deque = new ArrayDeque<>();

        public void add(int x) {
            while (!deque.isEmpty() && x > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offer(x);
        }

        public void remove(int x) {
            if (x == deque.peek()) {
                deque.poll();
            }
        }

        public int getMax() {
            return deque.peek();
        }
    }

}
