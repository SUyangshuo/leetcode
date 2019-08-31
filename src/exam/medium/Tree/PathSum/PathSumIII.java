package exam.medium.Tree.PathSum;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class PathSumIII {
    /**
     * 437. Path Sum III
     *  求二叉树中是否存在一条路径和为定值
     *
     * 重点：需要使用双层递归，外层递归遍历全局节点，内层递归从当前节点遍历路径和
     * 对每个节点使用前序遍历，如果存在路径和为taget的话 count++
     * @param root
     * @param sum
     * @return
     */
    private int count=0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null ){
            return 0;
        }

        dfs(root,sum,root.val);
        if(root.left!=null){
            pathSum(root.left,sum);
        }
        if(root.right!=null){
            pathSum(root.right,sum);
        }
        return count;

    }
    public void dfs(TreeNode root, int sum, int target ) {
        if(target==sum){
            count++;
        }
        if(root.left!=null){
            target+=root.left.val;

            dfs(root.left,sum,target);
            target-=root.left.val;
        }
        if(root.right!=null){
            target+=root.right.val;
            dfs(root.right,sum,target);
            target-=root.right.val;
        }
    }

}
