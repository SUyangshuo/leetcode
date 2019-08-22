package exam.medium.Tree.BST;

public class BinaryTreeMaximumPathSum {
    /**
     * 124. Binary Tree Maximum Path Sum
     * 寻找一个二叉搜索树中的最大值路径，
     *
     * 重点，使用递归的方式 求出左子树和右子树的最大路径值，max（root+left,root+right,root+left+right,root,right,left）
     * @param root
     * @return
     */
    public  static int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null && root.left==null){
           return root.val;
        }
         int   letfNumber=maxPathSum(root.left);

        int  rightNumber=maxPathSum(root.right);



        return Math.max(Math.max(Math.max(Math.max(Math.max(root.val+letfNumber,root.val+rightNumber)
                                ,root.val+letfNumber+rightNumber
                                ),root.val),letfNumber),rightNumber);

    }
    //优化
    private int max = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root){
        if(root==null)return 0;
        maxPathSumCore(root);
        return max;
    }

    private int maxPathSumCore(TreeNode root) {
        if(root==null)return 0;
        int leftMax = maxPathSumCore(root.left);
        int rightMax = maxPathSumCore(root.right);
        int path = Math.max(root.val,root.val+Math.max(leftMax,rightMax));//考虑返回给父节点的必须包含root的值
        max = Math.max(path,max);
        if(root.left!=null)
            max = Math.max(max,leftMax);
        if(root.right!=null)
            max = Math.max(max,rightMax);
        max = Math.max(max,root.val+leftMax+rightMax);//考虑全为+，求和取最大
        return path;//返回给父节点的必须包含当前root的值
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        a.right=c;
        a.left=b;
        maxPathSum(a);

    }
}
