package exam.medium.Recurrence.dp;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.uniquePaths(3,2);
    }
}
class Solution{
    /**
     * 62. Unique Paths
     * 求多少唯一路径，从左上角到右下角
     * 主要解题方案有两种，一种是使用普通递归，按照排列的做法，会产生大量重复计算
     * 还有一种是使用dp保存之前的局部最优解
     * 每个位置的路径是它的【i】【j-1】和【i-1】【j】的和
     * @param m
     * @param n
     * @return
     */
    //方法一：普通dp
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)dp[i][0]=1;
        for(int i=0;i<n;i++)dp[0][i]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }
    //优化dp---滚动优化，只使一维数组(一行)，就可以取得保存数据，【i】=【i-1】+【i】
    public int uniquePaths2(int m, int n) {
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        for(int j =1 ;j<m;j++){
            for(int i=1;i<n;i++){
                dp[i]=dp[i-1]+dp[i];
            }

        }

        return dp[n-1];
    }

}
