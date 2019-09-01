package exam.medium.Tree;

public class DiameterOfBinaryTree {
    /**
     * 543. Diameter of Binary Tree
     * 求二叉树的直径,同求二叉树的深度
     *
     * 分情况讨论，有两种情况，最长路径经过根节点，那直径就是左子树深度加右子树深度+1
     *                      最长路径不经过根节点，则最长路径为左子树深度和右子树深度的做大值，可以递归调用
     */
    int max = 0;
    //使用递归，搜索深度，但是时间较慢
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        max = Math.max(max, helper(root.left) + helper(root.right));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
    //递归优化，但是为什么这个速度快？？？
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];//保存最大值
        dfs(root, res);
        return res[0];
    }
    public int dfs(TreeNode root, int[] res) {
        // base case
        if (root == null) {
            return 0;
        }
        // pre-order traverse to get the solution from subtree
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        // do the Max operation at current node
        res[0] = Math.max(res[0], left + right);
        // return the max(left, right) + 1 to the parent of current node
        return Math.max(left, right) + 1;
    }
}
