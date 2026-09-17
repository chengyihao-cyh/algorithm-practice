package org.rereview2024summer.stack;

import java.util.ArrayDeque;

public class T6_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++)
            myQueue.push(nums[i]);
        res[0] = myQueue.getMax();

        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i - k]);
            myQueue.push(nums[i]);
            res[i - k + 1] = myQueue.getMax();
        }

        return res;
    }
    class MyQueue {
        private ArrayDeque<Integer> queue;
        public MyQueue() {
            this.queue = new ArrayDeque<>();
        }
        public void pop(int n) {
            if (!queue.isEmpty() && n == queue.peek())
                queue.pop();
        }
        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n)
                queue.removeLast();
            queue.addLast(n);
        }
        public int getMax() {
            return queue.peek();
        }
    }

}
