package exam.medium.Array;

public class SingleNumber {
    /**
     * 136. Single Number
     */
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i]; //直接位运算，相同的异或 位运算后就会编程0，
        }
        return result;
    }
    /**
     * 137. Single Number II
     *
     */
    public int singleNumber2(int[] nums) {
        if(nums == null||nums.length == 0){
            return -1;
        }
        //得到出现一次的数字的值
        int result=0;
        //int为4字节，那么共有32位
        for(int i=0;i<32;i++){
            /**
             *  使用位运算，因为其他元素都是出现3次，因此二进制表示中每一位上1的个数都是3的倍数，
             *  如果不是3的倍数，则就是多出来那个元素的值
             */
            //保存每一位求和值
            int sum=0;
            for(int j=0;j<nums.length;j++){
                //累加所有数字上第i位的数字
                sum+=(nums[j]>>i)&1;
                //System.out.println("sum"+sum);
            }
            //取余得到第i位上的数字，更新result
            result|=(sum%3)<<i;
            //System.out.println("res+"+result);
        }
        return result;
    }
    /**
     * 260. Single Number III
     数组中只出现一次的两个数字
     */
    public int[] singleNumber3(int[] nums) {
        int[] res=new int[2];
        if(nums == null||nums.length == 0){
            res[0]=0;
            res[1]=0;
            return res;
        }
        int sum=0;
        //计算出两个单独的数异或的结果
        for(int i=0;i<nums.length;i++){
            sum^=nums[i];
        }
        //找到第一个标记位，这个位置两个元素的值不同
        int count=0;
        while ((sum&1)==0){
            sum>>=1;//从右往左计算
            count++;
        }
        res[0]=0;
        res[1]=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&(1<<count))==0){//判断num【i】这个位置上的元素是否为0
                res[0]^=nums[i];
            }else{
                res[1]^=nums[i];
            }
        }
        return res;
    }

}
