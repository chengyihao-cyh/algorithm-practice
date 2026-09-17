package org.review2025springAgain.ch05_stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/3/10 09:29
 * @comment
 */
public class T8_calculate {
    Map<Character, Integer> map = Map.of('(', 0, '+', 1, '-', 1, '*', 2, '/', 2, '%', 2, '^', 3);
    ArrayDeque<Integer> numStack = new ArrayDeque<>();
    ArrayDeque<Character> optStack = new ArrayDeque<>();

    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] input = s.toCharArray();
        numStack.push(0);

        for (int i = 0; i < input.length; i++) {
            char ch = input[i];
            if (isNumber(ch)) {
                int n = 0;
                while (i < input.length && isNumber(input[i])) {
                    n = n * 10 + input[i] - '0';
                    i++;
                }
                numStack.push(n);
                i--;
            } else if (ch == '(') {
                optStack.push('(');
            } else if (ch == ')') {
                while (optStack.peek() != '(')
                    doCalc();
                optStack.pop();
            } else {
                if (i > 0 && input[i-1] == '(')
                    numStack.push(0);
                while (!optStack.isEmpty() && map.get(optStack.peek()) >= map.get(ch))
                    doCalc();
                optStack.push(ch);
            }
        }

        while (!optStack.isEmpty())
            doCalc();
        return numStack.pop();
    }

    public void doCalc() {
        char opt = optStack.pop();
        int num2 = numStack.pop();
        int num1 = numStack.pop();
        if (opt == '+') numStack.push(num1 + num2);
        else if (opt == '-') numStack.push(num1 - num2);
        else if (opt == '*') numStack.push(num1 * num2);
        else if (opt == '/') numStack.push(num1 / num2);
        else if (opt == '%') numStack.push(num1 % num2);
        else if (opt == '^') numStack.push(num1 ^ num2);
    }

    public boolean isNumber(char ch) {
        return Character.isDigit(ch);
    }
}
