package exam.medium.Recurrence.dp;

public class ClimbingStairs {
    /**
     * 70. Climbing Stairs
     * 用1和2组成n  求有多少种解法
     *
     * 使用斐波那锲数列
     *
     */
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        if(n>=1){
            dp[1]=1;
        }else {
            return 0;
        }
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
