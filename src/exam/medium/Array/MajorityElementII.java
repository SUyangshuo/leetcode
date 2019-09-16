package exam.medium.Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    /**
     * 229. Majority Element II
     *  找出数组中元素个数超过n/3的元素,
     *  重点，使用最大投票法，可知元素中超过n/3的元素最多只有两个
     *      将最大投票法改进成两个
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int candidate=0;int count=0;int candidate2=0;int count2=0;
        for(int i=0;i<nums.length;i++){
            /**
             * 重点：判断顺序非常重要
             * 需要注意的是，循环中判断的顺序很重要，
             * 需要先判断当前元素是否与两个 candidate 之一相匹配，若均不匹配，再判断 counter。
             * 原因在于最初的 candidate 需要如何确定。
             * 即便数组的长度大于等于2，依旧不能类似 Majority Element 那样，
             * 使用数组的前两个元素作为两个 candidate，因为数组的前两个元素可能是相同的。
             * 其实解决办法也很简单，只要给两个 candidate 赋予不同的初值，并且两个 counter 的初值均为 0 即可。
             如果先判断 counter，则有可能出现两个 candidate 相同的情况。如测试用例[2,2][2,2]，[−1,1,1,1,2,1]
             */
            if(candidate==nums[i]) {
                count++;
            }else if(candidate2==nums[i]) {
                count2++;
            }else if(count==0){
                count++;
                candidate=nums[i];
            }else if(count2==0){
                count2++;
                candidate2=nums[i];
            }else if(count>0 && count2>0){
                count--;
                count2--;
            }
        }
        int c1=0;
        int c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate){
                c1++;
            }else if(nums[i]==candidate2) {
                c2++;
            }
        }
        if(c1>nums.length/3){
            list.add(candidate);
        }
        if(c2>nums.length/3){
            list.add(candidate2);
        }
        return list;
    }
}
