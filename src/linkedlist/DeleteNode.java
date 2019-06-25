package linkedlist;

/**
 * 删除链表中的节点
 *
 * 描述：
 * 给定单链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 *
 * 分析：
 * 在单链表中删除一个节点，最常规的方法无疑是从链表的头结点开始，顺序遍历查找要删除的节点，并在链表中删除该节点。
 * 比如图a所表示的链表中，我们要删除节点i，可以从链表的头节点a开始顺序遍历，发现节点h的m_PNext指向要删除的节点i，
 * 于是我们可疑把节点h的m_PNext指向i的下一个节点即为j。指针调整之后，我们就可以安全地删除节点i并保证链表没有断开。
 * 这种思路由于需要顺序查找，时间复杂度自然就是O（n)了。
 */
public class DeleteNode {

    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (head == toBeDeleted && head.next == null) { // 链表中只有一个节点，那么待删除的节点既是头结点，又是尾结点
            head = null;
        }
        if (toBeDeleted.next != null) { // 被删除的节点不是尾节点
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        } else { // 被删除的节点是尾节点，则需要遍历
            ListNode temp = head;
            while (temp.next != toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        }
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
        deleteNode(head, head);
        printList(head);
    }
}
