package leetcodeCompetition.APRExplore;

/**
 * leetcode 4月30道挑战赛
 * 第一题：在一个非空数组中，一个数字出现两个，只有一个数字出现一次，找出这个数
 * 方法一：暴力搜索法，使用map结构，时间复杂度为o（n），空间复杂度为o(n/2)
 * 方法二：位运算，将数组全部元素进行位运算，位运算使用异或运算，结果剩下的就是出现一次的数
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result=result^nums[i];
        }
        return result;
    }

}
