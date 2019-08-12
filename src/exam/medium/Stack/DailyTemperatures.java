package exam.medium.Stack;

import java.util.Stack;

public class DailyTemperatures {
    /**
     * 739. Daily Temperatures
     * 描述：给定一个数组，求每个位置的值距离后边比该位置大的元素距离
     *
     * 重点：使用双重循环会超时
     *
     *       单调栈
     *      方法一：借助栈结构，从前往后遍历，栈内保存的时候元素对应的索引，
     *          顺序要保持索引对应的元素递减，遇到比栈顶元素大的就弹栈，
     *          索引差就是栈顶元素之后距离最近的大元素
     *
     *      方法二：借助栈结构，从后往前遍历，栈内要求同上
     */
    //从前往后遍历
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length<=0){
            return null;
        }
        int[] result=new int[T.length];
        Stack<Integer> stack=new Stack<>();//保持栈内递减的顺序

        for(int i=0;i<T.length;i++){
            if(stack.isEmpty()){
                stack.add(i);
                continue;
            }
            while(!stack.isEmpty() && T[stack.peek()]<T[i]){//弹栈
                int temp=stack.pop();
                result[temp]=i-temp;
            }
            stack.add(i);

        }
        return result;
    }
    //从后往前遍历，更节省时间，因为要求求的是元素之后的
    public static int[] dailyTemperatures2(int[] T) {
        if(T==null || T.length<=0){
            return null;
        }
        int[] result=new int[T.length];
        Stack<Integer> stack=new Stack<>();//保持栈内递减的顺序 从往前遍历，栈顶元素就是下一位大于本元素的索引

        for(int i=T.length-1;i>=0;i--){

            while(!stack.isEmpty() && T[stack.peek()]<=T[i]){//弹栈
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i]=stack.peek()-i;
            }else{
                result[i]=0;
            }
            stack.add(i);

        }


        return result;
    }

    public static void main(String[] args) {
        dailyTemperatures2(new int[]{89,62,70,58,47,47,46,76,100,70});
    }

}
