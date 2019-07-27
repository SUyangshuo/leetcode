package exam.medium.Recurrence.Ergodic;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
}


/**
 * 102. Binary Tree Level Order Traversal
 * 层次遍历二叉树
 */
 class Solution_level {
     //层次遍历通过队列结构
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root == null){
            return result;
        }
        List<Integer> first=new ArrayList<>();
        first.add(root.val);
        result.add(first);

        queue.add(root);
        level(result,queue);
        return result;
    }

    public void level(List<List<Integer>> list, Queue<TreeNode> queue){
        List<Integer> templist=new ArrayList<>();
        Queue<TreeNode> newsQueue=new LinkedList<>();
        if(queue.size()==0){
            return;
        }
        while(queue.size()>0){

            TreeNode top=queue.poll();
            if(top.left !=null){
                newsQueue.add(top.left);
                templist.add(top.left.val);
            }
            if(top.right != null){
                newsQueue.add(top.right);
                templist.add(top.right.val);
            }
        }
        if(templist.size()>0){
            list.add(new ArrayList<>(templist));
        }
        level(list,newsQueue);
    }
}