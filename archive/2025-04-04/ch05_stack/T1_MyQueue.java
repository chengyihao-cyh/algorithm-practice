package org.review2025spring.ch05_stack;

import java.util.ArrayDeque;
import java.util.LinkedList;

class T1_MyQueue {
    ArrayDeque<Integer> stackIn;
    ArrayDeque<Integer> stackOut;

    public T1_MyQueue() {
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<  >();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty())
            while (!stackIn.isEmpty())
                stackOut.push(stackIn.pop());
        return stackOut.pop();
    }

    public int peek() {
        if (stackOut.isEmpty())
            while (!stackIn.isEmpty())
                stackOut.push(stackIn.pop());
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
