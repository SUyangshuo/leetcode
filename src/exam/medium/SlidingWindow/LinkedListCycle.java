package exam.medium.SlidingWindow;

public class LinkedListCycle {
    /**
     * 141. Linked List Cycle
     * 判断链表中是否存在环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    /**
     * 142. Linked List Cycle II
     * 判断链表中是否存在环，并且找到环的起点
     */
    public ListNode detectCycle( ListNode head ) {
        if( head == null || head.next == null ){
            return null;
        }
        ListNode fp = head, sp = head;
        while( fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;
            //判断是否成环
            if( fp == sp ){
                break;
            }
        }
        if( fp == null || fp.next == null ){
            return null;
        }
        //fp到环入口距离 = head到环入口距离
        sp = head;
        while( fp != sp ){
            sp = sp.next;
            fp = fp.next;
        }
        return sp;
    }
}
