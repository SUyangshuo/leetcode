package exam.medium.Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * 84. Largest Rectangle in Histogram
     *  求直方图中 最大矩形面积
     *
     *  重点：使用单调栈，单调递增，寻找局部极值点
     */
    public static int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0){
            return 0;
        }
        //单调栈保持增长，遇到小于栈顶元素的处理,栈内保存的为数组下标，用于计算宽度
        Stack<Integer> stack=new Stack<>();
        int res = 0;
        int i=0;
        while(i<=heights.length){
            int temp=i<heights.length?heights[i]:0;
            if(stack.isEmpty() || temp>=heights[stack.peek()]){
                stack.push(i);
            }else {  //说明现在栈顶元素是局部最大值
                int cur = stack.pop();
                res = Math.max(res, heights[cur] * (stack.empty() ? i : (i - stack.peek()-1 )));
                --i;//保持i不变，
            }
            i++;
        }
        return  res;

    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{1});
    }
}
