package exam.medium.Recurrence.dp.KnapsackProblem;

public class TargetSum {
    /**
     * 494. Target Sum
     * 给定一串数组，可以使用加法或者减法，求最后的和等于s 有多少种方案
     *
     * 首先求出整个数组的和sum，（sum+s）/2就是新的s  求新s的组合方式
     * 背包问题
     */
    public static int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int sum=0;
        for(int temp:nums){
            sum+=temp;
        }
        if(sum<Math.abs(S) || (S==0 && sum%2!=0) || (sum+S)%2!=0){
            return 0;
        }
        S=(sum+S)/2;//todo:注意这里的是加，不是减

        int[] dp=new int[S+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=S;j>=nums[i];j--){ // todo:此处一定要从外到里计算！！！避免重复计算
                dp[j]=dp[j]+dp[j-nums[i]];
            }
        }
        return dp[S];
    }

    public static void main(String[] args) {
        int[] a=new int[]{5,2,2,7,3,7,9,0,2,3};
        findTargetSumWays(a,0);
    }
}
