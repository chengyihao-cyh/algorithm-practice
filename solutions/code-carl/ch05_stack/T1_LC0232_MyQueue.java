/**
 * Practice template for:
 * - LeetCode 232. Implement Queue using Stacks
 *   https://leetcode.cn/problems/implement-queue-using-stacks/
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class T1_LC0232_MyQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    public T1_LC0232_MyQueue() {
        this.stackIn = new ArrayDeque<>();
        this.stackOut = new ArrayDeque<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        int pop = this.pop();
        stackOut.push(pop);
        return pop;
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
