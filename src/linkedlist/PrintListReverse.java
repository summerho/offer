package linkedlist;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 题目描述：
 * 输入一个链表，从尾到头打印链表每个节点的值。返回新链表。
 *
 * 分析：
 * 可以借助栈也可以使用递归
 */
public class PrintListReverse {

    /**
     * 用栈的先进后出原理来实现
     * @param head
     */
    public static void printListReverseByStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }

    /**
     * 递归实现
     * @param head
     */
    public static void printListReverseByRecursion(ListNode head) {
        if (head == null) {
            return;
        }
        printListReverseByRecursion(head.next);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

//        printListReverseByStack(node1); // 调用栈方法
        printListReverseByRecursion(node1);
    }
}
