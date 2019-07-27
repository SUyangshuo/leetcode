package exam.medium.Recurrence.Ergodic;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] a=new int[]{1,2};
        int[] b=new int[]{1,2};
        Solution_binaryTree solution=new Solution_binaryTree();
        solution.buildTree(a,b);
    }
}

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 已知先序遍历和中序遍历，求 二叉树
 */
class Solution_binaryTree  {
    /**
     * 使用递归通过先序遍历和中序遍历可以不停的拆分
     * @param preorder
     * @param inorder
     * @return
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode newTree=new TreeNode(preorder[0]);
        //改进方案可以使用下标，代替新开辟的数组，降低空间复杂度
        for(int i=0;i<inorder.length;i++){
            if(preorder[0]==inorder[i]  &&inorder.length-1-i>=0){
                int[] newInorderl=new int[i];
                int[] newInorderr=new int[inorder.length-1-i];
                int[] newPreorderl=new int[i];
                int[] newPreorderr=new int[preorder.length-1-i];

                System.arraycopy(inorder,0,newInorderl,0,i);//中序遍历左子树
                System.arraycopy(inorder,i+1,newInorderr,0,inorder.length-1-i);//中序遍历右子树
                System.arraycopy(preorder,1,newPreorderl,0,i);
                System.arraycopy(preorder,i+1,newPreorderr,0,preorder.length-1-i);
                newTree.left=buildTree(newPreorderl,newInorderl);
                newTree.right=buildTree(newPreorderr,newInorderr);
            }
        }
        return newTree;
    }
}