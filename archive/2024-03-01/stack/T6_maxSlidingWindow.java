package org.learn2024spring.stack;

import java.util.ArrayDeque;
import java.util.Deque;

// 废弃版本
class T6_maxSlidingWindow0 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k)
                myQueue.remove(nums[i - k]);
            myQueue.add(nums[i]);
            if (i >= k - 1)
                res[i - k + 1] = myQueue.getMax();
        }

        return res;
    }
}

class T6_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++)
            myQueue.add(nums[i]);
        res[num++] = myQueue.getMax();

        for (int i = k; i < nums.length; i++) {
            myQueue.remove(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.getMax();
        }

        return res;
    }
}

class MyQueue {
    Deque<Integer> myqueue =  new ArrayDeque<>();
    void add (int value) {
        while (!myqueue.isEmpty() && myqueue.peekLast() < value) {
            myqueue.removeLast();
        }
        myqueue.add(value);
    }
    void remove (int value) {
        if (!myqueue.isEmpty() && value == myqueue.peek()) {
            myqueue.remove();
        }
    }
    int getMax () {
        return myqueue.peek();
    }
}
