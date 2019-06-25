package string;

import java.util.Stack;

/**
 * 翻转单词顺序
 * 例如输入输入“I am a student.”，则输出“student. a am I”
 */
public class ReverseWords {

    /**
     * 通过交换单词顺序实现
     * @param str
     * @return
     */
    public static String reverseWordsBySwrap(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] strArray = str.split(" ");
        int start = 0;
        int end = strArray.length - 1;
        while (start < end) {
            swrap(strArray, start, end);
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static void swrap(String[] array, int start, int end) {
        String temp;
        temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    /**
     * 通过栈的先进后出原理来实现
     * @param str
     * @return
     */
    public static String reverseWordsByStack(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] strArray = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (String s : strArray) {
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        System.out.print(reverseWordsByStack(str));
    }
}
