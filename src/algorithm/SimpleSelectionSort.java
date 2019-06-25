package algorithm;

/**
 * 简单选择排序
 */
public class SimpleSelectionSort {

    public static void simpleSelectionSort(int[] array) {
        int len = array.length;
        int min;
        int pos;
        for (int i = 0; i < len; i++) {
            min = array[i];
            pos = i;
            for (int j = i + 1; j < len; j ++) {
                if (min > array[j]) {
                    min = array[j];
                    pos = j;
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        simpleSelectionSort(array);
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}
