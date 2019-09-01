package exam.medium.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddOneRowToTree {
    /**
     * 623. Add One Row to Tree
     * 给二叉树的d行添加一行元素v
     *
     * 重点：方法一：使用两个队列进行层次遍历，d--，遇到d==1的情况下，进行插入
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        LinkedList<TreeNode> linkedList1=new LinkedList<>();
        LinkedList<TreeNode> linkedList2=new LinkedList<>();

        if(d==1){
            TreeNode newHead=new TreeNode(v);
            newHead.left=root;
            return newHead;
        }
        boolean index=true;
        //将第一个元素放入第一个队列
        linkedList1.add(root);
        d--;//每遍历一层将d--
        while( !linkedList1.isEmpty() && index){
            TreeNode temp=linkedList1.pop();
            if(temp.left!=null){
                linkedList2.add(temp.left);
            }
            if(temp.right!=null){
                linkedList2.add(temp.right);
            }
            if(linkedList1.isEmpty()){
                d--;
                if(d==1){
                   break;
                }
                while( !linkedList2.isEmpty()){
                    TreeNode temp2=linkedList2.pop();
                    if(temp2.left!=null){
                        linkedList1.add(temp2.left);
                    }
                    if(temp2.right!=null){
                        linkedList1.add(temp2.right);
                    }
                    if(linkedList2.isEmpty()){
                        d--;
                        if(d==1){
                            index=false;
                            break;
                        }
                    }

                }
            }
        }
        LinkedList<TreeNode> list=new LinkedList<>();
        list.addAll(linkedList1);
        list.addAll(linkedList2);
        while(!list.isEmpty()){
            TreeNode  temp=list.pop();
            TreeNode left=temp.left;
            TreeNode right=temp.right;
            TreeNode newNode1=new TreeNode(v);
            TreeNode newNode2=new TreeNode(v);
            newNode1.left=left;
            newNode2.right=right;
            temp.left=newNode1;
            temp.right=newNode2;
        }
        return root;
    }
    //优化方法
    public static TreeNode addOneRow2(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            newRoot.right = null;
            return newRoot;
        }
        else {
            recurseHelp(root,v,d,1);
        }
        return root;
    }
    public static void recurseHelp(TreeNode current, int v, int d, int currD) {
        if (current == null || currD >= d)
            return;
        else if (currD == d - 1) {
            TreeNode temp = null;

            temp = current.left;
            current.left = new TreeNode(v);
            current.left.left = temp;
            current.left.right = null;

            temp = current.right;
            current.right = new TreeNode(v);
            current.right.right = temp;
            current.right.left = null;

        }
        else {
            recurseHelp(current.left,v,d,currD + 1);//相当于对左右子树统计深度，当深度达到要求的时候进行插入
            recurseHelp(current.right,v,d,currD + 1);
        }
    }

}
