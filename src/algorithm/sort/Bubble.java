package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

//时间复杂度	O(n^2)
////稳定排序
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        boolean isSorted = false;
        //从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧
        //在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出
        for (int i = nums.length - 1; i >= 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    @Override
    public String type() {
        return "冒泡排序";
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
        Sort sort = new Bubble();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
