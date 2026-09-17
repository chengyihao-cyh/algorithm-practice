package org.rereview2024summer.stack;

import java.util.ArrayDeque;

public class T5_evalRPN {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-1 * stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push( num1 / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}
