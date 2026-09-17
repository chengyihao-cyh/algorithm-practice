package org.review2025spring.ch05_stack;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

class T2_MyStack {
    Deque<Integer> queue;

    public T2_MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offerLast(x);
    }

    public int pop() {
        int size = queue.size();
        while (size-- > 1) {
            queue.offerLast(queue.pollFirst());
        }
        return queue.pollFirst();
    }

    public int top() {
        int pop = this.pop();
        queue.offerLast(pop);
        return pop;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
