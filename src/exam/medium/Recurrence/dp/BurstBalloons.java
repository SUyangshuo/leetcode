package exam.medium.Recurrence.dp;

public class BurstBalloons {
    /**
     * 312. Burst Balloons
     * 动态数组求最优解，可以刺破一个数组，获得的收益为num[i-1]*num[i]*num[i+1],求全部气球刺破后最多的收益
     *
     * 重点：使用功能动态规划二维dp  dp【i】【j】表示i-j内的最大收益
     * 假如说区间i-j之间的某个气球k  最后被扎破，所产生的部分分为3块
     * 分别为为 [i k-1]   k    [k+1  j]   其中前一个和后一个的区间可以使用dp表示，k产生得到收益为num【i-1】*num【k】*num【j+1】
     * 所以状态转换方程为  max（dp[i][j], nums[i - 1] * nums[k] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]）
     *
     * 注意这个遍历顺序，需要先求最小的区间，然后区间依次扩展
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newnums = new int[n + 2];
        newnums[0] = 1; newnums[n + 1] = 1;
        for(int i = 0; i < n; i++){//为数组前后各添加一个元素1
            newnums[i + 1] = nums[i];
        }
        int[][] C = new int[n + 2][n + 2];
        return helper(newnums, C, 1, n);
    }

    int helper(int[] nums, int[][] C, int s, int e){
        if(s > e) return 0;
        if(C[s][e] > 0){
            return C[s][e];
        }
        for(int i = s; i <= e; i++){
            //使用了递归和dp两个解法 精妙
            int v = nums[s - 1] * nums[i] * nums[e + 1] + helper(nums, C, s, i - 1) + helper(nums, C, i + 1, e);
            C[s][e] = Math.max(C[s][e], v);
        }
        return C[s][e];
    }
}
