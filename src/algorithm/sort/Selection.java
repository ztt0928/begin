package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

//时间复杂度	O(n^2)
//非稳定排序
public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //选择最小的下标
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            //交换
            if (min != i) {
                swap(nums, i, min);
            }
        }
    }

    @Override
    public String type() {
        return "选择排序";
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
        Sort sort = new Selection();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
