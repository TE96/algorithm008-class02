package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：
 * 此处为不适用辅助栈的做法，最小值用变量维护
 * 辅助栈只在处理最小值时使用，可以在单个栈中特殊处理
 * @author fuwuchen
 */
public class MinStack {
    private Deque<Integer> stack;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack =  new LinkedList<>();
    }

    /**
     * push时先将min压入栈，再加入x
     * 以保存在x加入前的min
     */
    public void push(int x) {
        if (x <= min) {
            stack.addLast(min);
            min = x;
        }
        stack.addLast(x);
    }

    /**
     * pop时弹出当前最小值时
     * 栈中下一个元素就是当前最小值加入前的最小值
     */
    public void pop() {
        if (min == stack.removeLast()) {
            min = stack.removeLast();
        }
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return min;
    }
}