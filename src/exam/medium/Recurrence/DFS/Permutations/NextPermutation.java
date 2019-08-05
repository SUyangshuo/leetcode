package exam.medium.Recurrence.DFS.Permutations;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NextPermutation {
    /**
     * 31. Next Permutation
     * 给定一个排列，求当前排列的下一个排列
     *
     * 重点：找规律，从后往前遍历 找到一个位置i的数a，在i以后存在有一个位置j的数b，
     *          保证b》a并且没有比b更小的数（比a大的数）
     */
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=nums[i];
                }
                Arrays.sort(nums,i+1,nums.length);//对i位置以后的元素排序，保证最快的找到比i大的元素
                return;
            }
            Arrays.sort(nums,i,nums.length);//如果i位置没有，需要向前，对包括i的位置同样进行排列
        }
    }

}
