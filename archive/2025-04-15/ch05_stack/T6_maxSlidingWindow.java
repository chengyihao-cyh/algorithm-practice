package org.review2025springAgain.ch05_stack;

import java.util.ArrayDeque;

public class T6_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyDeque queue = new MyDeque();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = queue.get();
                queue.remove(nums[i - k + 1]);
            }
        }
        return res;
    }

    public class MyDeque {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        public void add(int i) {
            while (!deque.isEmpty() && deque.peekLast() < i)
                deque.removeLast();
            deque.add(i);
        }

        public void remove(int i) {
            if (!deque.isEmpty() && deque.peek() == i)
                deque.remove();
        }

        public int get() {
            return deque.peek();
        }
    }
}
