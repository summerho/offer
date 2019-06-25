package stack_queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class CQueue<E> {

    private Stack<E> stack1;
    private Stack<E> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(E node) {
        stack1.push(node);
    }

    public E deleteHead() {
        if (stack2.size() == 0) {
            if (stack1.size() == 0) {
                throw new RuntimeException();
            } else {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue<Integer> queue = new CQueue<>();
        for (int i = 0; i <= 10; i++) {
            queue.appendTail(i);
        }
        for (int i = 0; i < 5; i++) {
            int node = queue.deleteHead();
            System.out.print(node + "\t");
        }
    }
}
