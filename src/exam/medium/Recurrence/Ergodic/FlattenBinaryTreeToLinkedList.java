package exam.medium.Recurrence.Ergodic;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    /**
     * 114. Flatten Binary Tree to Linked List
     * 将一个二叉搜索树变为递增顺序单链表
     *
     * 重点，是一种特殊的前序遍历
     * 需要把左子树的全部节点放在右结点，右结点放在左子树的最后一个节点
     * @param root
     */
    //方法一 按照前序遍历改变树的结构
    public void flatten(TreeNode root) {
       while(root!=null){
           if(root.left!=null){
               TreeNode pre=root.left;
               //找到左节点先序遍历的最后一个节点
               while(pre.right!=null){
                   pre=pre.right;
               }
               pre.right=root.right;
               root.right=root.left;
               root.left=null;
           }
           root=root.right;
       }
    }
    //方法二：使用栈先进后出的功能，但是放置顺序为先放右子树，再放左子树，
    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (prev != null)
                prev.right = temp;
            temp.left = null;
            prev = temp;
        }
    }
}
