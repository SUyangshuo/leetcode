package exam.medium.Recurrence.dp;

public class PerfectSquares {
    /**
     * 279. Perfect Squares
     * 给定一个正整数n，找出最少的完全平方数使他们的和等于n。
     * 使用dp
    */
    public static void main(String[] args) {
        numSquares(12);
    }
    public static int numSquares(int n) {

        int[] dp=new int[n+1];
        /**
         * dp[0] = 0
         dp[1] = dp[0]+1 = 1
         dp[2] = dp[1]+1 = 2
         dp[3] = dp[2]+1 = 3
         dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
         = Min{ dp[3]+1, dp[0]+1 }
         = 1
         dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
         = Min{ dp [4]+1, dp[1]+1 }
         = 2
         */
        dp[0] = 0;
        dp[1] = dp[0]+1 ;

        for(int i=2;i<=n;i++){
            int j=1;
            dp[i]=n;
            while(i>=j*j){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);//todo：这里加1的原因，是因为递归的思想，1代表j*j
                j++;
            }
        }
        return dp[n];
    }
}
