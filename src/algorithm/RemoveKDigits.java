package algorithm;

import java.util.Stack;

/**
 * 删除整数的k个数字，得到删除后的最小值
 */
public class RemoveKDigits {

    public static String removeKDigits(String num, int k) {
        char[] numArray = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : numArray) {
            if (!stack.isEmpty()) {
                if (stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.print(removeKDigits("541270936", 3));
    }
}
