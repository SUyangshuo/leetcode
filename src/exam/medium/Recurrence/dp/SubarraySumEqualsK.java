package exam.medium.Recurrence.dp;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    /**
     * 560. Subarray Sum Equals K
     * 求有多少个连续子数组和等于k
     *
     * 重点：方法一：时间复杂度较高的方法，首先通过一个数组sum【i】保存i之前数的和
     *              然后双重for循环，遍历sum的组成方式，sum【j】-sum【i】？=k
     *      方法二：使用hash表保存sum的值，默认值为1,每次出现新sum值的时候，查看hash是否存在sum-k，存在的话，默认值加上hash值
     */

    //方法一 速度慢
    public static int subarraySum(int[] nums, int k) {

        int[] sum=new int[nums.length];//dp[i]表示i的组成方式
        sum[0]=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                sum[i]=nums[i];
            }else{
                sum[i]=sum[i-1]+nums[i];
            }
            if(sum[i]==k){
                count++;
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(sum[j]-sum[i]==k){
                    count++;
                }
            }
        }
        return count;
    }
    //方法二：使用hash表保存sum的值，默认值为1,每次出现新sum值的时候，查看hash是否存在sum-k，存在的话，默认值加上hash值
    public static int subarraySum2(int[] nums, int k) {

            Map<Integer, Integer> preSum = new HashMap();
            int sum = 0;
            int result = 0;
            preSum.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (preSum.containsKey(sum - k)) {
                    result += preSum.get(sum - k);
                }
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }
            return result;


    }


    public static void main(String[] args) {
        int[] a=new int[]{1,2,3};
        subarraySum2(a,3);
    }
}
