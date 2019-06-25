package algorithm;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 原始冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化：如果判断出数列已经有序，并作出标记，那么剩下的几轮排序就不必执行了，提前结束循环
     * @param array
     */
    public static void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 数组的前半部分无序，后半部分有序
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            // 无序数列的边界，每次比较只需比到这里为止
            int sortBorder = array.length - 1;
            for (int j = 0; j < sortBorder; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false; // 因为有元素进行交换，所以不是有序的，标记变为false
                    sortBorder = j; // 把无序数列的边界更新为最后一次交换元素的位置
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        int[] array1 = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
        bubbleSort1(array1);
        for (int value : array1) {
            System.out.print(value + "\t");
        }
    }
}
