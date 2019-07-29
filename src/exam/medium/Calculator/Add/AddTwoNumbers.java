package exam.medium.Calculator.Add;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}
public class AddTwoNumbers {
    /**
     * 2:Add Two Numbers
     * 使用两个链表模拟加法
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int quite=0;
        int unit =0;
        ListNode result = null;
        ListNode head = null;
        while(l1 !=null && l2 != null){
            int temp=l1.val + l2.val + quite;
            System.out.println("++"+temp);
            unit = temp%10;
            quite = temp/10;
            if(result == null){
                result = new ListNode(unit);
                head=result;

            }else {
                result.next = new ListNode(unit);
                result=result.next;
            }
            System.out.println("---"+unit);

            l1=l1.next;
            l2=l2.next;
        }

        while(l1 != null){
            if(result.next ==null){
                result.next = new ListNode(0);
            }
            int temp=l1.val + result.next.val + quite;
            System.out.println(" l1 "+result.val);
            unit = temp%10;
            quite = temp/10;

            result.next = new ListNode(unit);
            result=result.next;
            l1=l1.next;
        }
        while(l2 != null){
            if(result.next ==null){
                result.next = new ListNode(0);
            }
            int temp=l2.val + result.next.val + quite;
            System.out.println(" l2 "+temp);
            unit = temp%10;
            quite = temp/10;

            result.next = new ListNode(unit);
            result=result.next;
            l2=l2.next;
        }
        if(quite!=0){
            result.next = new ListNode(quite);
        }
        while(head != null){
            System.out.print(head.val);
            head=head.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode l11=new ListNode(1);
        l11.next=new ListNode(8);
        //l11.next.next=new ListNode(9);
        //l11.next.next.next=new ListNode(9);

        ListNode l21=new ListNode(0);
        //l21.next=new ListNode(9);
        //l21.next.next=new ListNode(9);
        addTwoNumbers(l21,l11);
    }
}
