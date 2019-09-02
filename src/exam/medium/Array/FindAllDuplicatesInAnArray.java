package exam.medium.Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    /**
     * 442. Find All Duplicates in an Array
     * 找出数组中重复的数字
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = Math.abs(nums[i]);
            // 在当前数字对应的下标（当前数字-1）处，使用正负进行标记
            // 例如，使用数组下标2 处所保存的数值正负来标识数字3是否已经出现过；
            // 若数字下标2处的数字为正数，表示3这个数字尚未出现过；
            // 若数字下标2处的数字为负数，表示3这个数字已经出现过一次。
            int targetNum = nums[currentNum - 1];
            if (targetNum < 0) {
                result.add(currentNum);
            } else {
                nums[currentNum - 1] = -targetNum;
            }
        }
        return result;
    }
}
