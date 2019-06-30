package algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * 实现括号是否匹配(给定一串字符串看括号是否成对出现)
 *
 * 基本思路：
 * 1、将字符串的每个字符进行遍历
 * 2、如果发现是左括号，那么将该字符压入到栈中
 * 3、如果是右括号，先去存储好的栈顶找到相应的值
 * 4、若栈为空返回false，若匹配，pop该左括号，若不匹配也返回false
 * 5、最后看存储栈中的做括号是否都匹配上了，也就是栈最后为空，返回true，否则返回false
 */
public class BracketMatch {

    public static boolean isMatch(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if (map.containsValue(temp)) { // 是否为左括号
                stack.push(temp);
            } else if (map.containsKey(temp)) { // 是否为右括号
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == map.get(temp)) { // 左右括号是否匹配
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("(***)-[{-------}]")); //true
        System.out.println(isMatch("(2+4)*a[5]")); //true
        System.out.println(isMatch("({}[]]])")); //false
        System.out.println(isMatch("())))")); //false
    }
}
