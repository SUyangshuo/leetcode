package exam.medium.Sort.ListSort;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class MergekSortedLists {
    /**
     * 23. Merge k Sorted Lists
     * 按照顺序合并k个链表
     *
     * 重点：方法一：使用归并排序
     *       方法二：优先队列
     */
    //方法一：归并排序
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        return recursion(lists,0,lists.length - 1);
    }
    //recursion
    public ListNode recursion(ListNode[] lists,int start,int end){
        if(start == end)//只有一个链表
            return lists[start];
        if(start < end){
            int mid = start + (end - start) / 2; //注意：这里防止整数越界的处理,start+(end-start)/2
            ListNode l1 = recursion(lists,start,mid);
            ListNode l2 = recursion(lists,mid + 1,end);
            return merge(l1,l2);
        } else
            return null;

    }
    //merge--两条链表之间归并，归并后的再选两个链表归并
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0); //创建一个头结点，最后还要删掉
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            } else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        p.next = (l1 != null) ? l1 : l2;
        return head.next;// head的下一个节点是第一个数据结点
    }
    //方法二：优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }

        //每次将k个链表的第一个元素加入到优先队列，然后弹出最小的元素，知道栈空
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) queue.add(lists[i]);//将k个元素添加到队列
        }
        ListNode dummy = new ListNode(-1), cur = dummy;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            cur.next = temp;
            cur = temp;
            if (temp.next != null) queue.add(temp.next);
        }
        return dummy.next;
    }
}
