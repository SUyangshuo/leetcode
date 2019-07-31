package exam.medium.Recurrence.Ergodic;

public class LowestCommonAncestorOfABinaryTree {
    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     * 求一颗二叉树上两个节点的最低公共父节点
     *
     * 重点：求父节点，根据遍历顺序，选择先序遍历
     *      其次两个节点右三种分布，一左一右，都在左子树，都在右子树
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==q){
           return q;
        }
        if(root==p){
            return p;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null &&right!=null){
            return root;
        }
        return left!=null?left:right;
    }
}
