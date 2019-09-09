package exam.medium.Tree;

import java.util.Stack;

public class InvertBinaryTree {
    /**
     * 226. Invert Binary Tree
     * 交换二叉树中的左右节点
     *
     * 递归 把每一棵子树左右旋转即可
     * 非递归，使用功能队列进行
     * @param root
     * @return
     */
    //递归

    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return root;

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }
    //非递归
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return root;
    }
}
