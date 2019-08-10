package exam.medium.Recurrence.DFS.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV {
    /**
     * 377. Combination Sum IV
     * 给定一个数组，没有重复，数组中几个数和为target ，求这样的组合有多少
     *
     * 这道题和之前的背包问题有些类似，但是有一些细节需要注意，有些背包问题是不对排序有要求，不允许重复，
     * 这个问题可以重复  遍历顺序需要颠倒
     * 两次遍历的顺序问题，dp遍历的前后问题
     * @param nums
     * @param target
     * @return
     */
    public static int combinationSum4(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return -1;
        }
        Arrays.sort(nums);//先排序
        int[] dp=new int[target+1];
        dp[0]=1;
        DP(dp,nums,target);

        return dp[target];
    }

    public static void DP(int[] dp,int[] nums,int target){
        //使用双重循环dp

            for(int j=0;j<=target;j++ ){
                for(int i=0;i<nums.length;i++){
                if(j-nums[i]>=0 ){
                    dp[j]=dp[j]+dp[j-nums[i]];
                }
            }
        }

    }

    public static void main(String[] args) {
        combinationSum4(new int[]{1, 2, 3},4 );
    }
}
