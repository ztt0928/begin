package sort.lxy;

/**
 * @author liuxinyi
 * @since 2019/10/31
 */

/**
 * 插入排序：
 * 从第一个元素开始，该元素可以认为是已经拍好序的第一个元素
 * 取出下一个元素，从已经排好序的的元素中从后往前遍历，找到就交换位置
 */
public class InsertSort {
    public static int[] insertionSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 8, 4, 7, 6, 9};
        int[] arrays = insertionSort(array);
        for (int num : arrays) {
            System.out.println(num);
        }
    }
}
