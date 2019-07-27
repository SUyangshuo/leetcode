package exam.medium.Recurrence.Ergodic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
}

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 之字形层次遍历
 * 利用两个栈结构
 */
class Solution_z {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();

        stack1.add(root);

        zTraversal(stack1,stack2,result);
        return result;
    }
    public void zTraversal(Stack<TreeNode> stack1, Stack<TreeNode> stack2, List<List<Integer>> list){
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        if(stack1.empty() && stack2.empty()){
            return;
        }
        while(!stack1.empty()){
            TreeNode temp=stack1.pop();
            list1.add(temp.val);
            if(temp.left !=null){
                stack2.add(temp.left);
            }
            if(temp.right!=null){
                stack2.add(temp.right);
            }
        }
        while(!stack2.empty()){
            TreeNode temp=stack2.pop();
            list2.add(temp.val);
            if(temp.right!=null){
                stack1.add(temp.right);
            }
            if(temp.left !=null){
                stack1.add(temp.left);
            }
        }
        if(list1.size()>0){
            list.add(list1);
        }
        if(list2.size()>0 ) {

            list.add(list2);
        }
        zTraversal(stack1,stack2,list);
    }

}
