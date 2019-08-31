package exam.medium.Recurrence.Ergodic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    /**
     * 128. Longest Consecutive Sequence
     *
     * 在一个未排序的数组中寻找最长递增序列，要求时间复杂度为on
     *
     * 重点：方法一：因为啥回件复杂度的要求，使用set或者map集合，利用set集合删除遍历，有新意
     */
    //将全部元素放到set中  便利一个元素，将set的元素删除一个，从该元素向上，或者向下遍历

    public int longestConsecutive(int[] num) {
            if (num == null || num.length == 0) return 0;
            // add number to hashset
            Set<Integer> hashset = new HashSet<Integer>();
            for (int n : num) {
                hashset.add(n);
            }
            int lcs = 0;
            for (int n : num) {
                int i = n, count = 1;
                hashset.remove(n);
                // i--
                while (hashset.contains(--i)) {
                    count++;
                    hashset.remove(i);
                }
                // i++
                i = n;
                while (hashset.contains(++i)) {
                    count++;
                    hashset.remove(i);
                }
                // update lcs
                lcs = Math.max(lcs, count);
            }
            return lcs;
    }

    //只能ac70% 每次只能更新num【i】前后的数字  更远的距离无法更新到，如果更改时间复杂度的话可以完成
    public static int longestConsecutive2(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }

        Map<Integer,Integer> map=new HashMap<>();
        int count=1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            int templeft=nums[i]-1;
            int tempRight=nums[i]+1;
            if(map.containsKey(templeft) && map.containsKey(tempRight)){
                int countTemp=map.get(templeft)+map.get(tempRight)+1;

                count=Math.max(count,countTemp);
                map.put(templeft,countTemp);
                map.put(tempRight,countTemp);
                map.put(nums[i],countTemp);
            }else if(map.containsKey(templeft) && !map.containsKey(tempRight)){//只包含比该值小的元素
                int countTemp=map.get(templeft)+1;
                count=Math.max(count,countTemp);
                map.put(templeft,countTemp);
                map.put(nums[i],countTemp);
            }else if(!map.containsKey(templeft) && map.containsKey(tempRight)){//只包含比该值大的元素
                int countTemp=map.get(tempRight)+1;
                count=Math.max(count,countTemp);
                map.put(tempRight,countTemp);
                map.put(nums[i],countTemp);
            }else if(!map.containsKey(templeft) && !map.containsKey(tempRight)){
                map.put(nums[i],1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        longestConsecutive2(new int[]{100,4,200,1,3,2});
        //[0,3,7,2,5,8,4,6,0,1]
    }
}
