package algorithm;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int start = 0; // 查找范围起点
        int end = array.length - 1; // 查找范围终点
        int mid; // 查找范围中位数
        // 迭代进行二分查找
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i;
        }
        System.out.print(binarySearch(array, 173));
    }
}
