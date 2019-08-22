package exam.medium.Link;
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class IntersectionOfTwoLinkedLists {
    /**
     * 160.Intersection of Two Linked Lists
     *
     * 查找两条单链表相等部分的开头
     *
     * 重点 ：方法一：分别遍历两条链表，如果两个链表长度相同，
     * 则逐位比较即可，如果两个链表长度不同，从长的链表差值的位置开始遍历，诸位比较，
     */

    //方法一：
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            int lenA = getLength(headA), lenB = getLength(headB);
            if (lenA > lenB) {
                for (int i = 0; i < lenA - lenB; ++i) headA = headA.next;
            } else {
                for (int i = 0; i < lenB - lenA; ++i) headB = headB.next;
            }
            while (headA != null && headB != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return (headA != null && headB != null) ? headA : null;
        }
        public int getLength(ListNode head) {
            int cnt = 0;
            while (head != null) {
                ++cnt;
                head = head.next;
            }
            return cnt;
        }
    //方法二：将两个串连接起来 当做环处理
    //最终一定在相同的点相遇，
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a != null) ? a.next : headB;
            b = (b != null) ? b.next : headA;
        }
        return a;
    }
}
