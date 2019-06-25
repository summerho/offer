package stack_queue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 实现一个栈，该栈带有出栈pop、入栈push、取最小元素getMin三个方法。要保证这三个方法的时间复杂度都是O(1)
 *
 * 分析：
 * 1.设原有的栈叫作栈A，此时创建一个额外的"备胎"栈B，用于辅助栈A
 * 2.当第一个元素进入栈A时，让新元素也进入栈B，这个唯一的元素是栈A当前最小值
 * 3.之后，每当有新元素进入栈A时，比较新元素和栈A当前最小值的大小，如果小于栈A当前最小值，则让新元素进入栈B，此时栈B的栈顶元素就是栈A当前最小值。
 * 4.每当栈A有元素出栈时，如果出栈元素是栈A当前最小值，则让栈B的栈顶元素也出栈。此时栈B余下的栈顶元素所指向的，是栈A当中原本第2小的元素，代替刚才
 * 的出栈元素成为栈A的当前最小值。
 */
public class MyStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MyStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int element) {
        mainStack.push(element);
        if (minStack.isEmpty() || minStack.peek() >= element) {
            minStack.push(element);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() {
        if (mainStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(4);
        myStack.push(9);
        myStack.push(7);
        myStack.push(3);
        myStack.push(8);
        myStack.push(5);
        System.out.println("min = " + myStack.getMin());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println("min = " + myStack.getMin());
    }
}
