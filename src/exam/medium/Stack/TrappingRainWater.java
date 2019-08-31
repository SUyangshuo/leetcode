package exam.medium.Stack;

import java.util.Stack;

public class TrappingRainWater {
    /**
     * 42. Trapping Rain Water
     * 给定n个非负整数，表示一个高程图，其中每个条的宽度为1，计算它在雨后能够截留多少水。
     *
     * 重点：使用dp，两次遍历，第一次找到每个位置左边最大的元素
     *      第二次遍历，找到每个位置右边最大的元素
     * @param height
     * @return
     */

    public int trap(int[] height) {
        int res = 0, mx = 0, n = height.length;
        int[] dp = new int[n];
        //每个位置左边最爱的元素
        for (int i = 0; i < n; ++i) {
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.min(dp[i], mx);//左边最高点和右边最高点的最小值
            mx = Math.max(mx, height[i]);
            if (dp[i] - height[i] > 0) {//重点：此时dp表示目前元素左边最大的元素和能遍历到的最大元素的小的那个
                res += dp[i] - height[i];
            }
        }
        return res;
    }
}
