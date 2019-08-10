package exam.medium.Recurrence.DFS.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * 40. Combination Sum II
     * 39题的变形  去掉了自环，增加了重复值
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates); //排序，使得寻找相同出权值的节点变得容易
        get(candidates, target, 0, list, res);
        return res;
    }

    private void get(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> res) {
        if (i > candidates.length || target < 0) return; //因为没有自环，所以每次都是从下一个节点开始搜索，要添加一个条件判断节点仍在图中
        if (target == 0) { //满足条件，添加至结果集
            res.add(new ArrayList<>(list));
            return;
        }
        for (int p = i; p < candidates.length; p++) {
            list.add(candidates[p]); //添加节点到路径
            get(candidates, target - candidates[p], p+1, list, res); //因为没有自环，所以每次搜索更新路径权值后的下一个节点
            list.remove(list.size()-1); //回溯，将当前节点从路径中剔除
            while (p < candidates.length - 1 && candidates[p] == candidates[p+1]) p++; //因为存在重复节点，所以已经被剔除的节点不能再被放回到路径中
        }
    }
}
