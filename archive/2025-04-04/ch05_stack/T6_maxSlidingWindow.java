package org.review2025spring.ch05_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T6_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        res[0] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.offer(nums[i]);
            res[i - k + 1] = queue.peek();

        }
        return res;
    }

    class MyQueue {
        Deque<Integer> queue = new ArrayDeque<>();

        public void offer(int x) {
            while (!queue.isEmpty() && queue.peekLast() < x)
                queue.pollLast();
            queue.offerLast(x);
        }

        public void poll(int x) {
            if (!queue.isEmpty() && x == queue.peekFirst())
                queue.pollFirst();
        }

        public int peek() {
            return queue.peekFirst();
        }

    }
}
