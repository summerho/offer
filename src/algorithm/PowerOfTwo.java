package algorithm;

/**
 * 判断一个数是否为2的整数次幂
 */
public class PowerOfTwo {

    public static boolean isPowerOf2(int num) {
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.print("120" + (isPowerOf2(120) ? "是" : "不是") + "2的整数次幂");
    }
}
