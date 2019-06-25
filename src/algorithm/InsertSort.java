package algorithm;

/**
 * 直接插入排序
 */
public class InsertSort {

    public static void insertSort(int[] array) {
        int len = array.length;
        int insertNum;
        for (int i = 1; i < len; i++) {
            insertNum = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > insertNum) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        insertSort(array);
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}
