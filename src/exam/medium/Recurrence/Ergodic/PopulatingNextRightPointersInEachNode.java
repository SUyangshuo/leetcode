package exam.medium.Recurrence.Ergodic;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulatingNextRightPointersInEachNode {
}

/**
 * 116. Populating Next Right Pointers in Each Node
 * 给一个平衡二叉树的每一个节点添加上右兄弟节点
 * 对于左节点，如果存在右结点的话，右兄弟节点就是父节点的右结点，如果没有右结点的话就为空
 * 对于右结点，如果父节点存在兄弟节点，右结点的右兄弟节点就是父节点的兄弟节点的左节点
 * 如此递归每一个节点即可
 */
class Solution_NextRightPointers {
    public Node connect(Node root) {
        if(root == null ){
            return null;
        }
        //左节点
        if(root.left!=null){
            if(root.right!=null ){
                root.left.next=root.right;
            }else{
                root.left.next=null;
            }
        }
        //右结点
        if(root.right!=null){
            if(root.next!=null ){
                root.right.next=root.next.left;
            }else{
                root.right.next=null;
            }
        }
        connect(root.left);
        connect(root.right);

        return root;
    }
}
