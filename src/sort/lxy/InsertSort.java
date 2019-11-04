package sort.lxy;
import java.util.Arrays;
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
    public static void insertionSort(int[] array) {
        if (array.length <= 1) {
            return ;
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
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 8, 4, 7, 6, 9};
        insertionSort(array);
        System.out.println(Arrays.toString(array));

    }
}
