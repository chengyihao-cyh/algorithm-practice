package org.review2024summer.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class T2_MyStack {
    private Queue<Integer> queue;

    public T2_MyStack() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
        return queue.remove();
    }

    public int top() {
        int res = pop();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
