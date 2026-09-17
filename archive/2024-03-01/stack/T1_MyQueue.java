package org.learn2024spring.stack;

import java.util.Stack;

class T1_MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public T1_MyQueue() {
        this.stackIn = new Stack<Integer>();
        this.stackOut = new Stack<Integer>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        // 千万注意pop的实现 由于是用先进后出的栈实现先进先出的队列 StackOut的元素相较于StackIn是先进入的 因此在pop时也先出
        // 只有当StackOut没有元素时 才将StackIn的所有元素倒进StackOut
        if (stackOut.empty())
            while (!stackIn.empty())
                stackOut.push(stackIn.pop());
        return stackOut.pop();
    }

    public int peek() {
        // peak只需获取队列顶元素而不用弹出 因此复用模拟队列的pop先弹出队列顶元素 在手动在StackOut中将该元素push回栈顶（也即队列顶）
        int res =  this.pop();
        stackOut.push(res);
        return res;

    }

    public boolean empty() {
        return stackOut.empty() && stackIn.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */