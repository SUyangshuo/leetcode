package exam.medium.Recurrence.Ergodic;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

/**
 * 92.Binary Tree Inorder Traversal
 * 中序遍历二叉树
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root == null){
            return list;
        }


        middle(root,list);
        return list;
    }
    public void middle(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left != null){
            middle(root.left,list);
        }
        list.add(root.val);

        if(root.right!=null){
            middle(root.right,list);
        }
    }
}
