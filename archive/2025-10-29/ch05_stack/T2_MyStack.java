package org.review2025autumn.ch05_stack;

import java.util.ArrayDeque;
import java.util.Deque;

class T2_MyStack {
    Deque<Integer> deque;

    public T2_MyStack() {
        this.deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.offerFirst(x);
    }

    public int pop() {
        return deque.pollFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
