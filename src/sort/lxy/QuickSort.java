package sort.lxy;

/**
 * @author liuxinyi
 * @since 2019/10/28
 */

public class QuickSort {
    public static void quickSortFun(int[] array, int low, int high) {
        if (array.length <= 0 || low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            while (left < right && array[left] <= temp) {
                left++;
            }
            if (left < right) {
                int t = array[left];
                array[left] = array[right];
                array[right] = t;
            }
        }
        array[low] = array[right];
        array[right] = temp;
        quickSortFun(array, low, left - 1);
        quickSortFun(array, left + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSortFun(array, 0, array.length - 1);
        for (int temp : array) {
            System.out.println(temp);
        }
    }
}
