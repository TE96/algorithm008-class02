package stack;

import java.util.Stack;

/**
 * 思路：
 * 用栈保存左半括号的信息，保存匹配的右半括号可以简化比较操作
 * 如果遇到右半括号，则弹出栈顶并比较，若不匹配则返回false
 * 如果遍历完字符串后栈为空则返回true
 * @author fuwuchen
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
