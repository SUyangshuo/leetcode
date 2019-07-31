package exam.medium.SlidingWindow;

public class IncreasingTripletSubsequence {
    /**
     * 334. Increasing Triplet Subsequence
     * 根据给定的数组，求该数组是否满足递增三元式  a[i]<a[j]<a[k]  i<j<k
     * 要求时间复杂度为n  空间复杂度为1，时间复杂度为n说明只能遍历一次
     * 方法一：使用双指针法
     * 方法二：dp ---不满足时间复杂度
     * 方法三：双数组法
     */
    //方法一 非主流
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int a=Integer.MAX_VALUE;
        int b=Integer.MIN_VALUE;
        boolean bFirst=true;
        //两个指针交替更新，a更新的条件是nums[i]<a  b更新的条件是nums[i]>a  之后b如果再次更新说明存在三元组
        //两个元素第一次更新后，还可以继续更新，a越来越小，b更新的条件是  a<nums[i]<b  当出现>b的情况的时候返回true
        for(int i=0;i<nums.length;i++){
            if(nums[i]<a){
                a=nums[i];
            }else if(nums[i] >a && nums[i]>b ){
                if(bFirst){
                    b=nums[i];
                    bFirst=false;
                }else {
                    return true;
                }
            }
            if(a<nums[i] && nums[i]<b){
                b=nums[i];
            }
        }
        return false;
    }
    //方法三：双数组法  空间复杂度不符合 时间比方法一也慢 但是能解决问题
    public boolean increasingTriplet3(int[] nums) {
        if(nums.length<=0 || nums == null){
            return false;
        }
        //表示i之前的元素最小值  （包含i元素）
        int[] f=new int[nums.length];
        //表示i之后的元素的最大值  （包含i元素）
        int[] b=new int[nums.length];
        f[0]=nums[0];
        b[nums.length-1]=nums[nums.length-1];
        //需要三次遍历 前两次遍历创建f和b数组
        for(int i=1;i<nums.length;i++){
            f[i]=Math.min(f[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>0;i--){
            b[i]=Math.max(b[i+1],nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>f[i] && nums[i]<b[i]){
                return true;
            }
        }
        return false;
    }

    /**方法二 dp  利用一个一维数组dp保存信息
     dp[i]表示数组i之前小于等于nums[i]的元素个数，
     更新条件是 当遇到j元素小于i元素时  dp[i]=max(dp[i],dp[j]+1)
     每到一个新位置，就需要遍历新位置之前的全部元素
     */
    //最慢
    public boolean increasingTriplet2(int[] nums) {
        if(nums.length<=0 || nums == null){
            return false;
        }
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    if(dp[i]>3){
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
