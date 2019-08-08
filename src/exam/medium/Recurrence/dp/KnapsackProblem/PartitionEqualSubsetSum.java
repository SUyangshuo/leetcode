package exam.medium.Recurrence.dp.KnapsackProblem;

import sun.plugin.viewer.LifeCycleManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionEqualSubsetSum {
    /**
     * 416. Partition Equal Subset Sum
     * 求一个数组是否可以分成和相同的两个子数组之和
     * 重点：一维dp  具体含义为dp【i】表示i是否可以由子数组组成
     *
     * 之前的dp都是从开始递推到最后一次即可，这次需要两次遍历一维dp
     * 第二个循环是变换全部的dp
     * 这一步的含义，是组成子数组的元素每多一个，就需要改变dp的结构，dp中有更多的i可以组成
     */
    public static boolean canPartition(int[] nums) {

        int add=0;
        for(int i =0;i<nums.length;i++){
            add+=nums[i];
        }
        //如果数组和为奇数，说明无法分为两个相同数的和
        if(add%2!=0){
            return false;
        }
        int target=add/2;
        //对数组排序，从大往小遍历
        Arrays.sort(nums);
        //利用一维dp dp【i】表示的含义是i是否可以由数组中 数组成
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        //转换方程  这种dp和之前的不一样，这次是双重for循环，
        // 第一个循环遍历数组，第二个循环是更新dp，意味着dp需要更新n轮
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,5,11,5};
        canPartition(a);
    }
}
