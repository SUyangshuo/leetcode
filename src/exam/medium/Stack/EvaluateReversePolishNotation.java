package exam.medium.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
}

/**
 * 150. Evaluate Reverse Polish Notation
 * 根据给的逆波兰表达式 计算等式结果
 * 对数组进栈，遇到符号弹栈两个
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack();
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")){
                stack.push(tokens[i]);
            }else if(!stack.empty()){
                Integer a=Integer.parseInt(stack.pop());
                Integer b=Integer.parseInt(stack.pop());
                if(tokens[i].equals("+") ){
                    stack.push(String.valueOf(a+b));
                }else if(tokens[i].equals("-") ){
                    stack.push(String.valueOf(a-b));
                }else if(tokens[i].equals("*") ){
                    stack.push(String.valueOf(a*b));
                }else if(tokens[i].equals("/") ){
                    if(a==0 || b==0){
                        stack.push(String.valueOf(0));
                    }else {
                        stack.push(String.valueOf(a/b));
                    }
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
    //提升了速度
    public int evalRPN2(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return -1;
        }
        int num1, num2;
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 + num1);
                    break;

                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;

                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 * num1);
                    break;

                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;

                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
