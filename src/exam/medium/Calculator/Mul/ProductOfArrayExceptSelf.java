package exam.medium.Calculator.Mul;

public class ProductOfArrayExceptSelf {
    /**
     * 238. Product of Array Except Self
     *给定一个数组，要求每一个位置上的数是其他位置上数的乘积，时间复杂度为n，并且不能使用除法
     *
     * 重要：无法使用出发就需要使用乘法代替出发，如果我们知道了某一位之前的乘积和之后的乘积，两个值相乘即可
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length==0){
            return null;
        }
        int[] a=new int[nums.length];//保存之前的乘积
        int[] b=new int[nums.length];//保存之后的乘积
        int ml=1;
        int mr=1;
        a[0]=1;
        b[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            a[i]=ml*=nums[i-1];
            b[nums.length-1-i]=mr*=nums[nums.length-i];
        }
        int[] result=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            result[i]=a[i]*b[i];
        }
        return result;

    }
}
