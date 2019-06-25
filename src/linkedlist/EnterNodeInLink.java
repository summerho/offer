package linkedlist;

/**
 * 链表中环的入口节点
 *
 * 题目描述：
 * 如果一个链表中包含环，如何找出环的入口节点？
 *
 * 分析：
 * 可以用两个指针来解决这个问题。先定义两个指针P1和P2指向链表的头结点。如果链表中环有n个结点，指针P1在链表上向前移动n步，
 * 然后两个指针以相同的速度向前移动。当第二个指针指向环的入口结点时，第一个指针已经围绕着环走了一圈又回到了入口结点。
 * 剩下的问题就是如何得到环中结点的数目。我们可以使用一快一慢的两个指针。如果两个指针相遇，表明链表中存在环。
 * 两个指针相遇的结点一定是在环中。可以从这个结点出发，一边继续向前移动一边计数，当再次回到这个结点时就可以得到环中结点数了。
 */
public class EnterNodeInLink {

    public ListNode getEnterNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode meetingNode = getMeetingNode(head);
        int ringLen = 0; // 环的长度
        if (meetingNode != null) { // 如果存在环，求出环的长度
            ListNode temp = meetingNode;
            meetingNode = meetingNode.next;
            while (meetingNode != temp) {
                ringLen++;
                meetingNode = meetingNode.next;
            }
            ringLen++;
        } else {
            return null;
        }
        ListNode front = head;
        ListNode behind = head;
        // 第一个指针先在链表上向前移动ringLength步
        while (ringLen > 0) {
            front = front.next;
            ringLen--;
        }
        // 两个指针以相同的速度移动，直到相遇为止，相遇的节点即为环的入口节点
        while (behind != front) {
            front = front.next;
            behind = behind.next;
        }
        return behind;
    }

    /**
     * 在链表存在环的情况下，找到一快一慢两个指针相遇的节点
     * @param head
     * @return
     */
    public ListNode getMeetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next; // 慢指针
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next; // 快指针
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            // 慢指针每次移动一步
            slow = slow.next;
            // 快指针每次移动两步
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        EnterNodeInLink test = new EnterNodeInLink();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = head;

        ListNode resultNode = test.getEnterNode(head);
        if(resultNode != null){
            System.out.println(resultNode.value);
        }else{
            System.out.println("您输入的参数有误！");
        }
    }
}
