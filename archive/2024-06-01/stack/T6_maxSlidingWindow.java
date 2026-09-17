package org.review2024summer.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T6_maxSlidingWindow {
    class MyQueue {
        private Deque<Integer> deque;
        public MyQueue() {
            this.deque = new ArrayDeque<>();
        }
        public void pop(int n){
            if (!deque.isEmpty() && deque.peek() == n)
                deque.pop();
        }
        public void push(int n){
            while (!deque.isEmpty() && n > deque.peekLast())
                deque.removeLast();
            deque.addLast(n);
        }

        public int getMax(){
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        res[0] = myQueue.getMax();
        for (int i = k; i < nums.length; i++) {
            myQueue.pop(nums[i - k]);
            myQueue.push(nums[i]);
            res[i - k + 1] = myQueue.getMax();
        }
        return res;
    }
}
