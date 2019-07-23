package exam.medium.DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    //todo:方法一：普通递归
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(res, nums, 0);
//        return res;
//    }
//
//    public static void dfs(List<List<Integer>> res, int[] nums, int cur) {
//        if (cur == nums.length) {
//            List<Integer> temp = new ArrayList<>();
//            for (Integer item : nums)
//                temp.add(item);
//            res.add(temp);
//        } else for (int i = cur; i < nums.length; i++) {
//            swap(nums, cur, i);
//              dfs(res, nums, cur + 1);
//            swap(nums, cur, i);
//        }
//    }
//
//    public static void swap(int[] arr, int a, int b) {
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }
    //todo:dfs
    public static   List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public static  void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            //注意不能直接添加temp
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

    public static void main(String[] args) {
        int[] a  = new int[]{1,2,3,4};
        List<List<Integer>> list=permute2(a);
    }
}
