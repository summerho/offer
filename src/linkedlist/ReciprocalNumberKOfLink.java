package linkedlist;

/**
 * 链表中倒数第k个节点
 *
 * 题目描述：
 * 输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1，2，3，4，5，6。这个链表的倒数第3个结点是值为4的结点。
 *
 * 分析:
 * 为了得到第K个结点，很自然的想法是先走到链表的尾端，再从尾端回溯K步。可是我们从链表结点的定义可以看出本题中的链表是单向链表，
 * 单向链表的结点只有从前往后的指针而没有从后往前的指针，因此这种思路行不通。既然不能从尾节点开始遍历这个链表，
 * 我们还是把思路回到头结点上来。假设整个链表有N个结点，那么倒数第K个结点就是从头结点开始的第n-k+1个结点。
 * 因此我们只能从头结点开始往后走n-k+1步就可以了。如何得到节点数n？这个不难，只需要从头开始遍历链表，每经过一个结点，
 * 计数器加1就行了。也就是说我们需要遍历链表两次，第一次统计出链表中结点的个数，第二次就能找到倒数第k个结点。
 * 但是当我们把这个思路解释给面试官之后，他会告诉我们他期待的解法只需要遍历链表一次。为了实现只遍历链表一次就能找到倒数第k个结点，
 * 我们可以定义两个指针。第一个指针从链表的头指针开始遍历向前走k-1。第二个指针保持不动；从第k步开始，
 * 第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，
 * 第二个指针正好是倒数第k个结点。
 */
public class ReciprocalNumberKOfLink {

    public static ListNode findKthToTail(ListNode head, int k) {
        // 参数校验(判断链表是否存在、k是否大于0)
        if (head == null || k <= 0) {
            return null;
        }
        ListNode front = head; // 前面的指针
        // 先让front向前走k-1步
        for (int i = 1; i <= k - 1; i++) {
            if (front.next != null) {
                front = front.next;
            } else {
                return null; // 当链表的长度小于k时，则返回null
            }
        }
        ListNode behind = head; // 后面的指针
        while (front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.value=1;
        temp1.value=2;
        temp2.value=3;
        temp3.value=4;
        temp4.value=5;
        temp5.value=6;
        temp6.value=7;
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        temp5.next=temp6;
        temp6.next=null;

        ListNode resultNode = findKthToTail(head, 3);
        if(resultNode != null){
            System.out.println(resultNode.value);
        }else{
            System.out.println("您输入的参数有误！");
        }
    }
}
