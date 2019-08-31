package exam.medium.Calculator.Add.IIIsum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 1. Two Sum
     * 求数组中两个数的和等于定值
     *
     * 使用功能map 空间换时间
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);

        }
        return null;
    }
}
