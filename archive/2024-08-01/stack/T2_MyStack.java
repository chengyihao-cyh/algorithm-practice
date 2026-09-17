package org.rereview2024summer.stack;

import java.util.ArrayDeque;
import java.util.Queue;

class T2_MyStack {
    private ArrayDeque<Integer> queue;

    public T2_MyStack() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.push(x);
    }

    public int pop() {
        int n = queue.size();
        while (n-- > 1) {
            queue.push(queue.pop());
        }
        return queue.pop();
    }

    public int top() {
        int res = this.pop();
        this.push(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
