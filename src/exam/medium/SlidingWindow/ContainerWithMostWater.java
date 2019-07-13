package exam.medium.SlidingWindow;

import java.util.List;
import java.util.function.Predicate;

/**
 * 11 Container With Most Water
 * 盛最多的水，
 *
 * 给定 n 个正整数 a1，a2，…，an，其中每个点的坐标用（i, ai）表示。 画 n 条直线，
 * 使得线 i 的两个端点处于（i，ai）和（i，0）处。请找出其中的两条直线，
 * 使得他们与 X 轴形成的容器能够装最多的水。
 注意：你不能倾斜容器，n 至少是2。
 *
 * 解法：有两种方法，第一种使用暴力解法，数据的组合遍历
 *                  第二种方法，利用滑动窗口，从底部最远的两个数开始，向两边中较小的那一边收缩，用一个标记值标记最大值
 */
public class ContainerWithMostWater {
    //滑动窗口
    public static int maxArea1(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l!=r){
            max=Math.max((r-l)*Math.min(height[l],height[r]),max);

            if(height[l]>=height[r]){
                r--;
            }else {
                l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a =new int[]{1,8,6,2,5,4,8,3,7};

       System.out.print(maxArea1(a));
    }



}
