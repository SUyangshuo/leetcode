package exam.medium.Tree;

import java.util.LinkedList;

public class CompleteBinaryTreeInserter {
    /**
     * 919. Complete Binary Tree Inserter
     * 向完全二叉树中插入元素
     *
     * 重点：可以设置一个index统计节点数
     * 可以使用list（堆）存储节点数据，需要找到父节点
     * 根据完全二叉树的性质，（leng（index）-1）/2;
     *
     */
    private int count=-1;
    private LinkedList<TreeNode>  result;
    public CompleteBinaryTreeInserter(TreeNode root) {
        //需要把root下的全部节点放在数组中，使用层次遍历
        result=new LinkedList<>();
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            TreeNode temp=linkedList.pop();
            result.add(temp);
            count++;
            if(temp.left!=null){
                linkedList.add(temp.left);
            }
            if(temp.right!=null){
                linkedList.add(temp.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode newNode=new TreeNode(v);
        count++;
        result.add(newNode);
        int prentes=(count-1)/2;
        if(result.get(prentes).left==null){
            result.get(prentes).left=newNode;
        }else{
            result.get(prentes).right=newNode;
        }
        return result.get(prentes).val;
    }

    public TreeNode get_root() {
        return result.get(0);
    }
}
