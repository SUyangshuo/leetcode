package exam.medium.PalindromicNumber.Link;
 class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class PalindromeLinkedList {
    /**
     * 234. Palindrome Linked List
     *描述：确定一个链表是不是回文的，要求时间复杂度为n 空间复杂度为1
     * 要求这个空间复杂度，因此不能借助栈
     * 重点 ：首先使用快慢指针，找到链表的中点，然后把中点之后的内容翻转，再从头和中点之后的元素比较
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode f=head;
        ListNode l=head;

        while(f!=null && f.next!=null){
            f=f.next.next;
            l=l.next;
        }
        //f不为空 说明 奇数个  此时l在中点   f为空 说明为偶数 此时l在中点偏右
        //后半段链表翻转， 最后l指向最后一个元素即可
        if(f!=null){
            l=l.next;
        }
        ListNode pre=null;
        while(l!=null){
            ListNode temp=l.next;
            l.next=pre;
            pre=l;
            l=temp;
        }
        while(pre!=null && head!=null){
            if(head.val!=pre.val){
                return false;
            }
            head=head.next;
            pre=pre.next;
        }
        return true;
    }
}
