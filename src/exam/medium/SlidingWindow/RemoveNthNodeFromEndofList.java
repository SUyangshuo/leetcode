package exam.medium.SlidingWindow;

/**
 *  19: Remove Nth Node From End of List
 *  删除倒数第n个节点，利用双指针法，第一个指针和第二个指针间隔为n
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class RemoveNthNodeFromEndofList {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int r=1  ;//l指向倒数第n个前一个元素，r最后指向最后一个元素
        int l=r-n-1;//注意双指针之间的间隔是n+1
        ListNode rnode=head,lnode=head;
        if(n==1&&rnode.next==null){
            return null;
        }

        while(rnode.next!=null){
            r++;
            l++;
            rnode=rnode.next;
            if(l>0){
                lnode=lnode.next;
            }
        }
        //删除元素是最后一个
        if(n==1){
            lnode.next=null;
        }else if(r!=n){
            lnode.next= lnode.next.next;
        }
        //删除元素是第一个元素
        if(r==n){
            return head.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);

        head1.next=head2;
        head2.next=head3;

        ListNode resu=removeNthFromEnd(head1,3);

        while(resu != null){
            System.out.println(resu.val);
            resu=resu.next;
        }

    }
}
