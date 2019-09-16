package exam.medium.Array;

public class MajorityElement {
    /**
     * 169. Majority Element
     * 找出数组中元素个数超过n/2的元素
     *
     * 重点：时间复杂度为on，空间复杂度为o1
     *
     * 摩尔投票法 Moore Voting
        遍历数组,当碰到两个不一样的数字时,将这两个数字同时丢弃，
        这两个数字中可能有一个为 Majority Element,也可能两个都不为Majority Element.
        因为k 大于 n/2,所以在最差情况下(每次移除不同数字时都包含一个Majority Element),
        我们仍然能够保证最后得到的数字是Majority Element.
        总之：在原序列中去除两个不同的元素后，在原序列中的多数元素在新序列中还是多数元素。
     */

    public int majorityElement(int[] nums) {
        int candidate=0;int count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                count++;
                candidate=nums[i];
            }else if(candidate==nums[i]) count++;
            else count--;
        }
        return candidate;
    }
}
