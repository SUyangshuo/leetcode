package exam.medium.Sort;

public class SortList {
    public static void main(String[] args) {
        ListNode a=new ListNode(4);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(1);
        ListNode d=new ListNode(3);
        a.next=b;
        b.next=c;
        c.next=d;
        Solution_sortList solu=new Solution_sortList();
        solu.sortList(a);
    }
}
/**
 * 148. Sort List
 * 要求在O（n*logn）的时间复杂度中，o1的空间复杂度中排列一个链表
 * 重要:首先是要求时间复杂度，
 * 常见的排序方案 冒泡排序、选择排序、插入排序的时间复杂度为O (n^2)，不满足要求。
 * 快速排序平均时间复杂度为O(n logn)，最差为O(n^2)，也不合适。再来看归并排序，时间复杂度为O(n log n)，满足要求
 * 需要选择合适的排序方案，其次，要符合空间复杂度
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution_sortList {
    /**
     * 归并排序，首先对链表进行拆分，拆分达到一个以后开始合并，
     * 对链表从中间拆分 技巧是利用快慢指针，前一个指针的移动速度是第二个指针的2倍
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newListNodeL=head;
        ListNode newListNodeR=head;
        ListNode leftEnd=head;
        while(newListNodeR!=null &&  newListNodeR.next!=null){
            leftEnd=newListNodeL;
            newListNodeL=newListNodeL.next;
            newListNodeR=newListNodeR.next.next;
        }
        //拆成了两段 头结点分别是head newListNodeL
        if(leftEnd!=null){
            leftEnd.next=null;
        }
        ListNode a=sortList(head);
        ListNode b=sortList(newListNodeL);

        return marge(a,b);
    }
    public ListNode marge(ListNode a,ListNode b){
        ListNode headIndex =new ListNode(1);
        ListNode head=headIndex;
        while(a!=null && b!=null){
            if(a.val<b.val){
                head.next=a;
                a=a.next;
            }else{
                head.next=b;
                b=b.next;
            }
            head=head.next;
        }
        if(a==null){
            head.next=b;
        }else {
            head.next=a;
        }
        return headIndex.next;
    }

}