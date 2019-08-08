package exam.medium.Recurrence.dp;

public class MinimumPathSum {
    /**
     * 64. Minimum Path Sum
     * 从左上角到右下角的最短路径和
     *
     * 使用dp，可以对dp优化，因为使用的是dp【i-1】【j】 和dp[i][j-1]
     * 所以可以优化为一维dp，或者不开辟新的空间，使用原数组即可
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m==0||n==0)
            return 0;

        int[][] dp = new int[m][n];

        dp[0][0]=grid[0][0];

        //a row
        for (int i = 1; i < n; i++)
            dp[0][i] = dp[0][i - 1] + grid[0][i];

        //a column
        for (int j = 1; j < m; j++)
            dp[j][0] = dp[j - 1][0] + grid[j][0];

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if(dp[i-1][j]<dp[i][j-1])
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                else
                    dp[i][j]=dp[i][j-1]+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
