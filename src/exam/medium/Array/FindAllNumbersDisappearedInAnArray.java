package exam.medium.Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    /**
     * 448. Find All Numbers Disappeared in an Array
     * 找出数组中从1-n中缺失的数，数组中有重复值
     * @param nums
     * @return
     */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int[] hash = new int[length];
        //利用数组保存信息 遍历数字
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < length;i++){
            hash[nums[i] - 1]++;
        }
        for(int i = 0; i < length;i++){
            if(hash[i] == 0){
                result.add(i + 1);
            }
        }
        return result;
    }

}
