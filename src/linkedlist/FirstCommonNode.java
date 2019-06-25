package linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 *
 * 题目要求：
 * 输入两个单链表，找出它们的第一个公共节点。
 *
 * 1 -> 2 -> 3 -> 6 -> 7
 * 0 -> 4 -> 5 -> 8 -> 9-> 10 -> 3 -> 6 -> 7
 * 第一个公共节点为6
 */
public class FirstCommonNode {

    /**
     * 分别存入两个栈来实现
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNodeByStack(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        ListNode cur1 = head1;
        while (cur1 != null) {
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        Stack<ListNode> stack2 = new Stack<>();
        ListNode cur2 = head2;
        while (cur2 != null) {
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        ListNode common = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode temp1 = stack1.pop();
            ListNode temp2 = stack2.pop();
            if (temp1.value != temp2.value) {
                break;
            } else {
                common = temp1;
            }
        }
        return common;
    }

    /**
     * 用Set，先存入第一个链表的所有结点，然后存入第二个链表的结点，当第一次添加失败的时候说明发现了第一个重复结点
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNodeBySet(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode common = null;
        while (temp1 != null) {
            set.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            if (set.add(temp2)) {
                temp2 = temp2.next;
            } else {
                common = temp2;
                break;
            }
        }
        return common;
    }

    /**
     * 长链表先行|n-m|步，转化为等长链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNodeByTwoPointer(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != null) {
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            len2++;
            cur2 = cur2.next;
        }
        cur1 = head1;
        cur2 = head2;
        while (len1 > len2) {
            cur1 = cur1.next;
            len1--;
        }
        while (len1 < len2) {
            cur2 = cur2.next;
            len2--;
        }
        while (cur1 != null) {
            if (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else {
                break;
            }
        }
        return cur1;
    }

    public void printList(ListNode head){
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
        head1.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 6;
        temp4.value = 7;
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
        ListNode temp9 = new ListNode();
        head2.value = 0;
        temp5.value = 4;
        temp6.value = 5;
        temp7.value = 8;
        temp8.value = 9;
        temp9.value = 10;
        head2.next = temp5;
        temp5.next = temp6;
        temp6.next = temp7;
        temp7.next = temp8;
        temp8.next = temp9;
        temp9.next = temp2;

        FirstCommonNode test = new FirstCommonNode();

        test.printList(head1);
        System.out.print("\n");
        test.printList(head2);
        System.out.print("\n");

        ListNode commonNode = test.findFirstCommonNodeBySet(head1, head2);
        if (commonNode != null) {
            System.out.print("第一个公共节点为 " + commonNode.value + "\t");
        } else {
            System.out.print("没有公共节点");
        }
    }
}
