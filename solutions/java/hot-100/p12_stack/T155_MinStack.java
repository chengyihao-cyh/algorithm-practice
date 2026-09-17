/**
 * Practice template for:
 * - 155. Min Stack
 *   https://leetcode.cn/problems/min-stack/
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 22:40
 * @comment
 */
public class T155_MinStack {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            this.stack = new ArrayDeque<>();
            this.minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            int pop = stack.pop();
            if (Objects.equals(pop, minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }
}
