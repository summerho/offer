package linkedlist;

/**
 * 合并两个排序的链表
 *
 * 题目描述：
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。例如输入图中的链表1和链表2，则合并之后的升序链表3所示。
 * 链表1 1->3->5->7
 * 链表2 2->4->6->8
 * 链表3 1->2->3->4->5->6->7->8
 *
 * 分析：
 * 这是一个经常被各公司采用的面试题。在面试过程中，我们发现应聘者最容易犯两个错误：一是在写代码之前没有对合并的过程想清楚，
 * 最终合并出来的链表要么中间断开要么并没有递增排序；二是代码的鲁棒性方面存在问题，程序一旦有特殊的输入（如空链表）就会崩溃。
 * 接下来分析如何解决这个问题。首先分析合并两个链表的过程。我们的分析从合并两个链表的头结点开始。链表1的头结点的值小于链表2的头结点的值，
 * 因此链表1的头结点将是合并后链表的头结点，我们继续合并两个链表中剩余的结点。在两个链表中剩下的结点依然是排序的，
 * 因此合并这两个链表的步骤和前面的步骤是一样的。我们还是比较两个头结点的值。此时链表2的头结点的值小于链表1的头结点的值，
 * 因此链表2的头结点的值将是合并剩余结点得到的链表的头结点。我们把这个结点和前面合并链表时得到的链表的尾节点链接起来，如图所示。
 * 当我们得到两个链表中值较小的头结点并把它链接到已经合并的链表之后，两个链表剩余的结点依然是排序的，因此合并的步骤和之前的步骤是一样的。
 * 这就是典型的递归的过程，我们可疑定义递归函数完成这一合并过程。接下来我们来解决鲁棒性的问题。
 * 每当代码试图访问空指针指向的内存时程序就会崩溃，从而导致鲁棒性问题。在本题中一旦输入空的链表就会引入空的指针，
 * 因此我们要对空链表单独处理。当第一个链表是空链表，也就是它的头结点是一个空指针时，那么把它和第二个链表合并，
 * 显然合并的过程就是第二个链表。同样，当输入的第二个链表的头结点是空指针的时候，我们把它和第一个链表合并得到的结果就是第一个链表。
 * 如果两个链表都是空链表，合并的结果是得到一个空链表。
 */
public class MergeList {

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if (head1.value < head2.value) {
            mergeHead = head1;
            head1 = head1.next;
        } else {
            mergeHead = head2;
            head2 = head2.next;
        }
        ListNode temp = mergeHead;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 == null) {
            temp.next = head2;
        } else {
            temp.next = head1;
        }
        return mergeHead;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.value + "  ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        head1.value = 0;
        temp1.value = 2;
        temp2.value = 4;
        temp3.value = 6;
        temp4.value = 8;
        head1.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = null;

        ListNode head2 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();
        ListNode temp7 = new ListNode();
        ListNode temp8 = new ListNode();
        head2.value = 3;
        temp5.value = 5;
        temp6.value = 7;
        temp7.value = 9;
        temp8.value = 11;
        head2.next = temp5;
        temp5.next = temp6;
        temp6.next = temp7;
        temp7.next = temp8;
        temp8.next = null;

        printList(head1);
        System.out.println("\n");
        printList(head2);
        System.out.println("\n");
        printList(merge(head1, head2));

    }
}
