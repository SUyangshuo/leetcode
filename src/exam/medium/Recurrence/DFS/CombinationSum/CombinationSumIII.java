package exam.medium.Recurrence.DFS.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {
    /**
     *216. Combination Sum III
     * 39,40题的变种
     * 要求使用k个数 组成的和为n  ke个数位1-9中挑选，每个数使用一次
     *
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        if ( k <= 0 || n <= 0) return res;
        List<Integer> list = new ArrayList<>();
        get( n, 1, list, res,k);
        return res;
    }

    private static void get( int target, int i, List<Integer> list, List<List<Integer>> res,int k) {
        if ( target < 0) return; //因为没有自环，所以每次都是从下一个节点开始搜索，要添加一个条件判断节点仍在图中
        if (target == 0 && list.size()==k) { //满足条件，添加至结果集
            res.add(new ArrayList<>(list));
            return;
        }
        for (int p = i; p < 10; p++) {
            list.add(p); //添加节点到路径
            get( target - p, p+1, list, res,k); //因为没有自环，所以每次搜索更新路径权值后的下一个节点
            list.remove(list.size()-1); //回溯，将当前节点从路径中剔除
        }
    }

    public static void main(String[] args) {
        combinationSum3(3,15);
    }
}
