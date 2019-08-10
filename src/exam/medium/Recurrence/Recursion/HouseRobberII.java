package exam.medium.Recurrence.Recursion;

public class HouseRobberII {
    /**
     * 213. House Robber II
     * 给定一个数组，求从数组中挑选一些数，求和最大，但是要求位置不能相邻，最后一个和第一个相连
     *
     * 重点：因为最后一个和第一个相连，我们把第一个和最后一个元素分别去掉，求中间的最大值，取两者之间较大的
     *
     * 在198. House Robber延伸而来，增加了循环这一条件
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        return Math.max(robsub(nums,0,nums.length-2),robsub(nums,1,nums.length-1));

    }
    public int robsub(int[] nums,int left,int right) {
        int[] dp=new int[right+1];
        if(right==left){
            return nums[right];
        }
        dp[left]=nums[left];
        dp[left+1]=Math.max(nums[left],nums[left+1]);
        for(int i=left+2;i<=right;i++){
            //两种情况
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[right];
    }
    //针对dp进行优化，需要使用两个变量代替dp 分别记录前一个最大值和前前一个最大值
    /**
     * int pre = 0, cur = 0;
     for (int i = l; i <= r; i++) {
     int temp = max(pre + nums[i], cur);
     pre = cur;
     cur = temp;
     }
     return cur
     */
}
