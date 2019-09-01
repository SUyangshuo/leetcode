package exam.medium.Recurrence.dp;

public class MinimumCostToMergeStones {
    /**
     * 1000. Minimum Cost to Merge Stones
     * 最小代价的合并石头，每次合并k个位置
     * 和312. Burst Balloons类似，，不会------
     * 重点：使用小区间表示大区间
     *
     *
     *
     */
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        //首先判断是否可以合并为一堆，可知减少的总堆数为n-1，每次减少的堆数位k-1 因此这两个数是否可以整除表示整个堆是否可以合并
        if ((n-1) % (K-1) != 0) return -1;

        //位置保存前n个位置的和
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; ++i)
            prefix[i+1] = prefix[i] + stones[i];

        //dp【i】【j】表示i-j之间的最小合并代价
        int[][] dp = new int[n][n];

        for (int l = 2; l <= n; ++l) {//每次合并的位置
            for (int i = 0; i <= n-l; ++i) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m+1][j]);
                if ((j-i) % (K-1) == 0)
                    dp[i][j] += prefix[j+1] - prefix[i];
            }
        }

        return dp[0][n-1];
    }
}
