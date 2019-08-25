package exam.medium.DataStructure;

import java.util.Stack;

public class MinStack {
    /**
     * 155. Min Stack
     * 设计一个栈，支持push、pop、top和在常量时间内检索最小元素。
     *
     * 使用一个单调栈 单调递减 栈顶元素是最小的
     */
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
