package org.learn2024spring.stack;

import java.util.*;


class T2_MyStack1 {
    private Queue<Integer> queue;

    public T2_MyStack1() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
        size--;
        while (size-- > 0)
            queue.add(queue.remove());
        return queue.remove();
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

class T2_MyStack2 {
    private Deque<Integer> queue;

    public T2_MyStack2() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        return queue.removeLast();
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}