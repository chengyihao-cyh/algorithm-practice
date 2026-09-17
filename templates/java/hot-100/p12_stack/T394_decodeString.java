/**
 * Practice template for:
 * - 394. Decode String
 *   https://leetcode.cn/problems/decode-string/
 */
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/8 21:43
 * @comment
 */
public class T394_decodeString {
    public String decodeString(String s) {
        Deque<String> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (Character.isDigit(ch)) {
                if (!numStack.isEmpty() && i > 0 && Character.isDigit(array[i - 1])) {
                    // 前一位也是数字，当前 i 是数字的一部分
                    Integer currNum = numStack.pop();
                    numStack.push(ch - '0' + currNum * 10);
                } else {
                    // 前一位不是数字，当前 i 是数字的起始
                    numStack.push(ch - '0');
                }
            } else if (ch == '[') {
                strStack.push("[");
            } else if (Character.isLetter(ch)) {
                strStack.push(String.valueOf(ch));
            } else if (ch == ']') {
                // 把两个括号间的 str 都倒出，逆向拼成 sub
                StringBuilder sub = new StringBuilder();
                while (!strStack.isEmpty() && !"[".equals(strStack.peek())) {
                    String str = strStack.pop();
                    sub.insert(0, str);
                }
                strStack.pop(); // pop '['
                // 把 sub 做 num 次重复，然后装入栈
                Integer num = numStack.pop();
                StringBuilder nSub = new StringBuilder();
                while (num-- > 0) {
                    nSub.append(sub);
                }
                strStack.push(nSub.toString());
            }
        }

        StringBuilder ansStr = new StringBuilder();
        while (!strStack.isEmpty()) {
            ansStr.insert(0, strStack.pop());
        }
        return ansStr.toString();
    }

    public String decodeString2(String s) {
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                Integer repeat = numStack.pop();
                StringBuilder decoded = strStack.pop();
                while (repeat-- > 0) {
                    decoded.append(curr);
                }
                curr = decoded;
            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }

}
