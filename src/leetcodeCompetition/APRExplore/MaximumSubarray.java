package leetcodeCompetition.APRExplore;

/**
 * 最大子数组和
 * 返回给定数组中最大子数组和
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] a=new int[]{-1,-2};
        maxSubArray(a);
    }
    //方法一：使用dp动态规划
    public static int maxSubArray(int[] nums) {
        //使用一维dp
        //状态转移方程dp[i]=max(num[i],dp[i-1]+num[i])
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
    //方法二：使用分治法
}
