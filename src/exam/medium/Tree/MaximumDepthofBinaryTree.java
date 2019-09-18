package exam.medium.Tree;

public class MaximumDepthofBinaryTree {
    /**
     * 104. Maximum Depth of Binary Tree
     * 输出二叉树的深度
     *
     * 重点：利用递归输出最大的左右节点深度
     */
    public int maxDepth(TreeNode root) {
      int count=recursion(root);
      return count;

    }
    public int recursion(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(recursion(root.left)+1,recursion(root.right)+1);
    }


}
