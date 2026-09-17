package org.review2025springAgain.ch05_stack;

import java.util.ArrayDeque;

public class T5_evalRPN {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    stack.push(-1 * stack.pop() + stack.pop());
                    break;
                case "/":
                    Integer num1 = stack.pop();
                    Integer num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
