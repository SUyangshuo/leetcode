package exam.medium.Recurrence.DFS.Permutations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermutationsII {
    /**
     * 47. Permutations II
     * 在一个可能重复的数组遍历全部的排列
     *
     * 方法一：遍历全部的排列，利用哈希表进行去重
     * 方法二：借鉴next permutation的做法，每次都是下一个最大的数组
     */

    //方法一：
    public static   List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public static  void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            //注意不能直接添加temp
            //创建一个hashmap；
            res.add(new ArrayList<>(temp)); //以一个集合或数组初始化ArrayList al = new ArrayList(a);//a为集合或数组
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//记录某个下标的数是否被使用过
                temp.add(nums[i]);
                used[i] = true;
                dfs(res, temp, nums, used);
                temp.remove(temp.size() - 1); //移除最后一个
                used[i] = false;
            }
        }
    }
    //方法二：
    public static List<List<Integer>> solution2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
        }
        list.add(temp);
        nextPermutation(nums,list);
        return list;

    }
    public static void nextPermutation(int[] nums,List<List<Integer>> list){
        int i=0;
        boolean index=false;
        for(i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    Arrays.sort(nums,i+1,nums.length);//对i位置以后的元素排序，保证最快的找到比i大的元素
                    index=true;
                    break;
                }
            }
            if(index){
                break;
            }
            Arrays.sort(nums,i,nums.length);//如果i位置没有，需要向前，对包括i的位置同样进行排列

        }
        if(i==-1){
            return;
        }

        List<Integer> tempList=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            tempList.add(nums[j]);
        }
        list.add(tempList);
        nextPermutation(nums,list);

    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,1};
        solution2(a);
    }

}
