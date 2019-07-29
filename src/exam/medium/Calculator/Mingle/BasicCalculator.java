package exam.medium.Calculator.Mingle;

import java.util.Stack;

public class BasicCalculator {

    /**
     * 227. Basic Calculator II
     * 根据给定的字符串  计算响应的结果
     * 方法一，给每个数字带上正负号压进栈，遇到乘除就弹出上一个数字运算 然后压栈 最后计算一个和
     */
    public static void main(String[] args) {
        calculate2("3+5/2 ");
    }
    //方法一
    public static int calculate2(String s) {
        if(s==null){
            throw  new IllegalArgumentException();
        }

        int d=0;//记录压栈的值
        int res=0;  //记录最后的结果

        Character sign='+';  //记录的是前一个符号，也就是数字前的符号

        Stack<Integer> nums=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'){
                d=d*10+s.charAt(i)-'0';
            }
            if(s.charAt(i)<'0' && s.charAt(i)!=' '|| i==s.length()-1){//表示长度 能省就省 不要转化
                //todo：相当于给每个数字带上了正负号，默认第一个数字的符号是正数
                //遇到第二个符号才对第一个符号计算
                if(sign=='+') nums.push(d);
                if(sign=='-') nums.push(-d);

                if(sign=='*' || sign=='/'){
                    int temp=sign=='*'?nums.pop()*d:nums.pop()/d;
                    nums.push(temp);
                }
                //压栈后重新记录符号和数字
                sign=s.charAt(i);
                d=0;
            }
        }
        //处理加减
        while (!nums.empty()){
            res+=nums.pop();
        }

        System.out.print(res);
        return res;
    }




}
