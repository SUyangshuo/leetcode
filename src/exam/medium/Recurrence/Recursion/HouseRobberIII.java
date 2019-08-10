package exam.medium.Recurrence.Recursion;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class HouseRobberIII {

    /**
     * 337. House Robber III
     * 遍历二叉树中的节点权值，要求遍历和最大，并且两个节点不能是父子关系
     *
     * 重点：求权值和最大，并且不能是父子关系的节点，有两种情况
     *       情况一：根节点+不包含左节点的最大权值和+不包含右结点的最大权值和
     *       情况二：左节点最大权值和+右结点最大权值和----不包含根节点，左右节点是否包含都可以
     *
     *       这种题需要先分解问题，把大问题分解成小问题，小问题的和就是大问题，需要使用递归
     */
    public  int rob(TreeNode root) {
        int result=0;
        result=robsub(root,new HashMap<>());
        return result;
    }
    public int robsub(TreeNode root, Map<TreeNode,Integer> map){
        if(root==null){
            return 0;
        }
        //todo:为什么要用map ？因为两种情况下是两种递归方式，如果不使用map把已经计算后的节点保存下 会有很多节点重复计算多次
        if (map.containsKey(root)) return map.get(root);

        int val=0;
        //包含根节点,不好喊左右节点
        if(root.left!=null){
            val+=robsub(root.left.left,map)+robsub(root.left.right,map);
        }
        if(root.right!=null){
            val+=robsub(root.right.left,map)+robsub(root.right.right,map);
        }
        //不包含根节点和包含根节点的最大值
        int result=Math.max(root.val+val,robsub(root.left,map)+robsub(root.right,map));
        map.put(root,result);
        return result;

    }
}
