/**
 * Practice template for:
 * - LeetCode 225. Implement Stack using Queues
 *   https://leetcode.cn/problems/implement-stack-using-queues/
 */
import java.util.ArrayDeque;
import java.util.Deque;

class T2_LC0225_MyStack {
    Deque<Integer> deque;

    public T2_LC0225_MyStack() {
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
