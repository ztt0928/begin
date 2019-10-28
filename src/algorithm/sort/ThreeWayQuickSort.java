package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

//三项切分
/*对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序*/
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    protected void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            if (less(nums[i], v)) {
                swap(nums, lt++, i++);
            } else if (more(nums[i], v)) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("请输入待排序的数组长度：");
        int m = sc.nextInt();
        Integer[] number = new Integer[m];
        System.out.println("请输入待排序的数组：");
        for (int i = 0; i < m; i++) {
            number[i] = sc.nextInt();
        }
        //23 45 22 11 2 539 2 40 59 5
        Sort sort = new ThreeWayQuickSort();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
