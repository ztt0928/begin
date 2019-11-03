package sort.cx;

import java.util.Arrays;
import java.util.Scanner;

//自底向上（循环遍历，先归并小数组）
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[]) new Comparable[N];
        for (int step = 1; step < N; step *= 2) {
            for (int left = 0; left < N - step; left += 2 * step) {
                merge(nums, left, left + step - 1, Math.min(left + 2 * step - 1, N - 1));
            }
        }

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
        Sort sort = new Down2UpMergeSort();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
