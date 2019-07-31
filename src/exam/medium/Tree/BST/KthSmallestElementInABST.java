package exam.medium.Tree.BST;

import java.util.ArrayList;
import java.util.List;

//TreeNode已经存在
public class KthSmallestElementInABST {
    /**
     * 230. Kth Smallest Element in a BST
     * 查找一棵树中第k小的元素
     * 重点：对二叉搜索树进行先序遍历，二叉搜索树的特点是左子树<中心节点<右子树，第n个元素就是倒数第n小的数
     */
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list=new ArrayList<>();
        preorder(list,k,root);

        return list.get(k-1).val;
    }
    public void preorder(List<TreeNode> list,int k,TreeNode root){
        if(root==null || list.size()==k){
            return;
        }

        if(root.left!=null){
            preorder(list,k,root.left);
        }
        list.add(root);
        if(list.size()==k){
            return ;
        }
        if(root.right!=null){
            preorder(list,k,root.right);
        }

    }
}
