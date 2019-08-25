package exam.medium.Recurrence.dp;

import java.util.Stack;

public class MaximalRectangle {
    /**
     * 85. Maximal Rectangle
     * 求0-1矩阵中的全为1的面积
     *
     * 方法一：使用84. Largest Rectangle in Histogram 的方法，将每一层向上看做一个直方图，有n层就是n个直方图
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length<=0|| matrix[0].length<=0){
            return 0;
        }
       //对矩阵进行处理
        int[][] temp=new int[matrix.length][matrix[0].length];
        int result=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    temp[i][j]=matrix[i][j]-'0';
                }else if(matrix[i][j]-'0'==1){
                    temp[i][j]=temp[i-1][j]+1;
                }else {
                    temp[i][j]=0;
                }
            }
            result=Math.max(largestRectangleArea(temp[i]),result);
        }
        return result;
    }
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
}
