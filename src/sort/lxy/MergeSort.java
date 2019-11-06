package sort.lxy;

import java.util.Arrays;

/**
 * @author liuxinyi
 * @since 2019/11/6
 */
public class MergeSort {
    public static void mergeSortFun(int[] array) {
        int[] temp = new int[array.length];
        mergeSortFun(array, 0, array.length - 1, temp);
    }

    public static void mergeSortFun(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边归并
            mergeSortFun(array, left, mid, temp);
            // 右边归并
            mergeSortFun(array, mid + 1, right, temp);
            // merge
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = array[i++];
        }

        while (j <= right) {
            temp[t++] = array[j++];
        }
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 8, 4, 7, 6, 9};
        mergeSortFun(array);
        System.out.println(Arrays.toString(array));
    }
}
