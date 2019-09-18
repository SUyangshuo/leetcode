package exam.medium.Recurrence.Ergodic;

 class MorrisTraval {
    /**
     * 函数的递归调用，递归的深度等于二叉树的高度，也就是说递归导致的调用堆栈的高度等于二叉树的高度，
     * 这样的话，程序虽然没有显示的通过new 来分配内存，但实际上消耗的内存大小也是 O(h).
     * 如果二叉树的高度很大，例如搜索引擎把几十亿张网页按照权重来组成二叉树的话，
     * 那么二叉树的高度也要几十万作用，因此按照传统的中序遍历，需要消耗大量的内存。
     */
     /**
      * Morris 方法遍历之所以能够在 O(1) 的空间的条件下完成是因为它充分利用到叶子的左右孩子来记录上层关系，
      * 从而不需要额外的栈空间来记录顺序关系。通过三种遍历可以看到，其实总体上的代码逻辑没有发生改变，
      * 主要是改变了输出结果的时机和方式。
      */
    //todo：中序遍历
    private TreeNode root = null;
    public MorrisTraval(TreeNode r) {
        this.root = r;
    }
    public void travel() {
        TreeNode n = this.root;
        while (n != null) {
            //当前节点的左节点为空，说明前置节点为空，打印本节点即可 然后转向右结点
            if (n.left == null) {
                System.out.print(n.val + " ");
                n = n.right;
            } else {
                TreeNode pre = getPredecessor(n);//获得当前节点的前置节点，前置节点都在左边，因为是中序遍历

                //判断前置节点的几种情况
                if (pre.right == null) {
                    //前置节点的右结点为空，将前置节点的右子树连接到当前节点，当前节点移动到左节点
                    pre.right = n;
                    n = n.left;
                }else if (pre.right == n) {
                    //如果前置节点的右结点等于当前节点，说明之前已经连接了，断开这种连接，然后打印当前节点，
                    pre.right = null;
                    System.out.print(n.val + " ");
                    n = n.right;
                }
            }
        }
    }
    private TreeNode getPredecessor(TreeNode n) {
        TreeNode pre = n;
        if (n.left != null) {
            pre = pre.left;
            while (pre.right != null && pre.right != n) {
                pre = pre.right;
            }
        }
        return pre;
    }
}
//todo:前序遍历
class MorrisTraval2 {
    private TreeNode root = null;
    public MorrisTraval2(TreeNode r) {
        this.root = r;
    }
    public void travel() {
        TreeNode n = this.root;
        while (n != null) {
            //当前节点的左节点为空，说明前置节点为空，打印本节点即可 然后转向右结点
            if (n.left == null) {
                System.out.print(n.val + " ");
                n = n.right;
            } else {
                //当前节点的左子树中找出前驱节点 pre
                TreeNode pre = getPredecessor(n);

                //判断前置节点的几种情况
                if (pre.right == null) {
                    //前置节点的右结点为空，将前置节点的右子树连接到当前节点，当前节点移动到左节点
                    pre.right = n;
                    //todo：和中序遍历的区别在这里，在将前置节点连接到当前节点的时候打印
                    System.out.print(n.val + " ");

                    n = n.left;
                }else if (pre.right == n) {
                    //如果前置节点的右结点等于当前节点，说明之前已经连接了，断开这种连接，然后打印当前节点，
                    pre.right = null;
                    //中序遍历在这里打印
//                    System.out.print(n.val + " ");
                    n = n.right;
                }
            }
        }
    }
    private TreeNode getPredecessor(TreeNode n) {
        TreeNode pre = n;
        if (n.left != null) {
            pre = pre.left;
            while (pre.right != null && pre.right != n) {
                pre = pre.right;
            }
        }
        return pre;
    }
}
//todo：后序遍历
class MorrisTraval3{
    public static void morrisPos(Node head) {
        if (head == null) {
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            //先判断当前节点的左节点
            if (cur2 != null) {//当前节点的左节点存在
                //找到左节点的中序遍历的最后一个节点，即是前置节点
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                //如果前置节点的右结点为空，将该节点的右结点指向
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                     continue;
                } else {
                    cur2.right = null;
                    printEdge(cur1.left);//和中序遍历的区别在于后序遍历是倒序输出
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }
    //节点输出
    public static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }
    //翻转节点
    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        //链表反转
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
 }
