package leetcodeCompetition.APRExplore;

/**
 * 最大子数组和
 * 返回给定数组中最大子数组和
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] a=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray2(a);
    }
    //方法一：使用dp动态规划
    public static int maxSubArray(int[] nums) {
        //使用一维dp
        //状态转移方程dp[i]=max(num[i],dp[i-1]+num[i])
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
    /**
     * 方法二：使用分治法
     * 分治法的使用在于分割中间值，将数组分割为两个部分，
     */
    public static int maxSubArray2(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return solution(nums,0,nums.length-1);

    }
    public static int solution2(int[] nums,int i,int m,int j) {
        //计算两个部分，前半部分带m的数组和 和后半部分不带m的数组和

        //注意：从中间向两边扩散
        int leftMax=Integer.MIN_VALUE;
        int sum=0;
        for(int a=m;a>=i;a--){
            sum+=nums[a];
            leftMax=Math.max(sum,leftMax);
        }
        int rightMax=Integer.MIN_VALUE;
        sum=0;
        for(int a=m+1;a<=j;a++){
            sum+=nums[a];
            rightMax=Math.max(sum,rightMax);
        }
        return rightMax+leftMax;
    }
    public static int solution(int[] nums,int i,int j) {
        if(i==j){
            return nums[i];
        }

        int m =i+(j-i)/2;
        return Math.max(solution(nums,i,m),
                Math.max(solution(nums,m+1,j),solution2(nums,i,m,j)));
    }

}
