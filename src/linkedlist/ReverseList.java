package linkedlist;

/**
 * 反转链表
 *
 * 题目描述：
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的链表的头结点。
 */
public class ReverseList {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode revHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = revHead;
            revHead = cur;
            cur = temp;
        }
        return revHead;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.value + "  ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.value = 0;
        temp1.value = 1;
        temp2.value = 2;
        temp3.value = 3;
        temp4.value = 4;
        temp5.value = 5;
        temp6.value = 6;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = null;

        printList(head);
        System.out.println("\n");
        printList(reverse(head));
    }
}
