package exam.medium.Tree;

import sun.font.TrueTypeFont;

class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class SymmetricTree {
    /**
     * 101. Symmetric Tree
     * 判断二叉树是否是中心对称的
     *
     * 重点：
     *       方法二：使用递归，判断左右子树是否是中心对称的
     * @param root
     * @return
     */
    //方法一：前序遍历
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // if two nodes are null
        if(left == null && right == null)
            return true;
        // is one node is null, another is another
        if(left == null || right == null)
            return false;
        // if two nodes value are not same
        if(left.val != right.val)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }
}
