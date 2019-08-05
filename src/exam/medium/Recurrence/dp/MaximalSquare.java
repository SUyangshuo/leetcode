package exam.medium.Recurrence.dp;

public class MaximalSquare {
    /**
     * 221. Maximal Square
     * 求二维矩阵中由1组成的面积最大的正方形的面积
     *
     * 使用dp，dp[i][j]表示以i j 为右下角的正方形的边长
     * 根据观察，可知每个点的正方形边长和dp[i-1][j-1],  dp[i][j-1]  dp[i-1][j] 三个值决定，
     * dp【i】【j】=min(dp[i-1][j-1],  dp[i][j-1]  dp[i-1][j] )+1
     * 如果matrix【i】【j】=0,直接等于0
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int max=0;
        int[][] dp =new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j]=matrix[i][j]-'0';
                if(matrix[i][j]=='1'){
                    if(max < 1) max =1;
                    if(i - 1 < 0 || j - 1 < 0 )continue;
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max*max;
    }
}
