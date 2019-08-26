package exam.medium.Recurrence.Ergodic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 后序遍历 {
    /**
     * 145. Binary Tree Postorder Traversal
     * 二叉树的后序遍历
     *
     * 重点：方法一：递归
     *      方法二：用栈
     * @param root
     * @return
     */
    //方法一：递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root==null){
            return resultList;
        }
        help(resultList,root);
        return resultList;
    }
    public void help(List<Integer> resultList,TreeNode root){
        if(root==null){
            return;
        }
        help(resultList,root.left);
        help(resultList,root.right);
        resultList.add(root.val);
    }
    //使用栈
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        List<Integer> list=new ArrayList<>();
        while(root!=null){
            if (root.right!=null) {
                stack.push(root.right);
            }
            if (root.left!=null) {
                stack.push(root.left);
            }
            root=root.left==null?root.right:root.left;
        }
        while(!stack.isEmpty()){
            list.add(stack.peek().val);
            if(){

            }

        }
        return list;
    }
}
