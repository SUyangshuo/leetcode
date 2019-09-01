package exam.medium.Tree.BST;

import java.util.Stack;

public class ConvertBSTToGreaterTree {
    /**
     * 538. Convert BST to Greater Tree
     * 改变二叉搜索树中的每一个节点，将节点值改为比自己元素大的所有元素和
     *
     * 按照从右 中 左的顺序遍历即可，把每一步的节点值count+
     */
    public int count=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        solution(root);
        return root;

    }
    public void solution(TreeNode root){
        if(root==null){
            return;
        }
        solution(root.right);
        root.val=root.val+count;
        count=root.val;
        solution(root.left);
    }
}
