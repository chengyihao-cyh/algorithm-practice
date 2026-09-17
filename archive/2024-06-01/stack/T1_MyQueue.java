package org.review2024summer.stack;

import java.util.Stack;

public class T1_MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public T1_MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.empty())
            while (!inStack.empty())
                outStack.push(inStack.pop());
        return outStack.pop();
    }

    public int peek() {
        int res = pop();
        outStack.push(res);
        return res;
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}
