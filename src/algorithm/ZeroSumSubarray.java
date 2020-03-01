package algorithm;

/**
 * 给一个整数数组，判断其中是否存在子数组的和为0
 * 例，
 * Input: {3, 4, -7, 3, 1, 3, 1, -4, -2, -2}
 * Output: true
 * 和为0的子数组如下（子数组中的数是连续）
 * {3, 4, -7}
 * {4, -7, 3}
 * {-7, 3, 1, 3}
 * {3, 1, -4}
 * {3, 1, 3, 1, -4, -2, -2}
 * {3, 4, -7, 3, 1, 3, 1, -4, -2, -2}
 */
public class ZeroSumSubarray {

    public static void zeroSumSubarray(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += arr[j];
                if (sum == 0) {
                    System.out.println("Subarray [" + i + ".." + j + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        zeroSumSubarray(arr);
    }
}
