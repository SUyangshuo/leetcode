package exam.medium.Tree.PathSum;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /**
     * 113. Path Sum II
     * 输出从头结点开始的路径和等于target的路径
     */
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null){
            return result;
        }
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        dfs(root,sum,list,root.val);
        return result;
    }
    public void dfs(TreeNode root, int sum, List<Integer> list ,int target) {
        if (root.left==null  && root.right==null && target==sum){
            result.add(new ArrayList<>(list));
        }
        if(root.left!=null){
            list.add(root.left.val);
            target+=root.left.val;
            dfs(root.left,sum,list,target);
            target-=root.left.val;
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            list.add(root.right.val);
            target+=root.right.val;
            dfs(root.right,sum,list,target);
            target-=root.right.val;
            list.remove(list.size()-1);
        }
    }
}
