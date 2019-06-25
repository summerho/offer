package algorithm;

/**
 * 旋转有序数组二分查找
 * https://mp.weixin.qq.com/s/33aOwDGFQ5omE3sHmVLXVA
 *
 * 普通有序数组： 2 5 7 9 12 14 20 26 30
 * 旋转有序数组： 12 14 20 26 30 2 5 7 9
 * 2为旋转点
 */
public class RotatedBinarySearch {

    public static int rotatedBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            }
            // 情况A：旋转点在中位数右侧
            if (array[mid] >= array[start]) {
                // 最左侧元素 <= 查找目标 < 中位数
                if (array[start] <= target && target < array[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // 情况B：旋转点在中位数左侧，或与中位数重合
                // 中位数 < 查找目标 <= 最右侧元素
                if (array[mid] < target && target <= array[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 旋转数组的最小数字
     * @param array
     * @return
     */
    public static int getMinByRotatedBinarySearch(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        int min = -1;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                min = array[end];
                break;
            }
            mid = start + (end - start) / 2;
            // 中位数在旋转点左侧
            if (array[mid] > array[start]) {
                start = mid;
            } else { // 中位数在旋转点右侧
                end = mid;
            }
        }
        return min;
    }

    /**
     * 数字在排序数组中出现的次数
     * 输入{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
     *
     * 解题思路：
     * 排序数组，定位某一个数值的位置，很容易想到二分查找。分成两部分：求第一个出现该值的位置start，求最后一个出现该值得位置end，
     * end-start+1即为所求。
     * @param array
     * @param k
     * @return
     */
    public static int getNumOfK(int[] array, int k) {
        int len = array.length;
        if (len == 0 || array[0] > k || array[len - 1] < k) {
            return 0;
        }
        return getEndOfK(array, k) - getStartOfK(array, k) + 1;
    }

    private static int getStartOfK(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            if (start == end) {
                if (array[start] == k) {
                    return start;
                } else {
                    return 0;
                }
            }
            mid = start + (end - start) / 2;
            // k在前半段
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) { // k在后半段
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    private static int getEndOfK(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            if (start == end) {
                if (array[end] == k) {
                    return end;
                } else {
                    return 0;
                }
            }
            mid = start + (end - start) / 2;
            // k在前半段
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) { // k在后半段
                start = mid + 1;
            } else {
                start = mid;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于k的元素
     * @param array
     * @param k
     * @return
     */
    public static int findLastLessthanK(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] >= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return array[end];
    }

    /**
     * 查找第一个大于k的元素
     * @param array
     * @param k
     * @return
     */
    public static int findFirstGreaterthanK(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return array[start];
    }

    public static void main(String[] args) {
//        int[] array = new int[]{9, 10, 11, 12, 13, 15, 17, 19, 22, 24, 27, 33, 35, 38, 40, 41, 43, 45, 0, 3, 4, 5, 8};
//        System.out.print(getMinByRotatedBinarySearch(array));
        int[] array = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 9, 11, 12};
        System.out.print(findFirstGreaterthanK(array, 8));
    }
}
