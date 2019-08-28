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
    //使用栈--空间复杂度为o（树的高度，需要自己创造一个数据结构，表示节点是否被访问过）
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
//            if(){
//
//            }

        }
        return list;
    }
    //使用 两个栈，一个用来存储逆序遍历，一个用来存储右边的中间节点--但是空间复杂度为o（n）
    public void thePostOrderTraversal_Stack(TreeNode root) {   //后序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();//构造一个中间栈来存储逆后序遍历的结果
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        System.out.println(output.size());
        while (output.size() > 0) {

            //printNode(output.pop());
        }
    }
}
