package exam.medium.Sort.ListSort;

public class MergeTwoSortedLists {
    /**
     * 21. Merge Two Sorted Lists
     * 对两个链表归并排序
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = null;
        if (l1.val < l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        ListNode head = res;

        while (l1 != null || l2 != null) {

            if ((l1 != null && l2 != null && l1.val < l2.val) || (l1 != null && l2 == null)) {
                res.next = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        res.next = null;
        return head;
    }
}
