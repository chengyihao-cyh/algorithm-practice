package org.rereview2024summer.stack;

import java.util.ArrayDeque;
import java.util.Stack;

class T1_MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public T1_MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
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
        int res = this.pop();
        stackOut.push(res);
        return res;
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
