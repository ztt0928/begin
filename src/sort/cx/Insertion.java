package sort.cx;

import java.util.Arrays;
import java.util.Scanner;

//平均时间复杂度	最好情况	最坏情况	空间复杂度
//        O(n²)	O(n)	O(n²)	O(1)
//稳定排序
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    /**
     * 插入排序
     * <p>
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     *
     * @param nums 待排序数组
     */
   /* 对于数组 {3, 5, 2, 4, 1}，它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4, 1)，
    插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量*/
    @Override
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 取出下一个元素，在已经排序的元素序列中从后向前扫描
            T temp = nums[i + 1];
            int j = i;
            for (; j >= 0 && less(temp, nums[j]); j--) {
                // 如果该元素（已排序）大于取出的元素temp，将该元素移到下一位置
                nums[j + 1] = nums[j];
            }
            // 将新元素插入到该位置后
            nums[j + 1] = temp;
        }
    }

    @Override
    public String type() {
        return "插入排序";
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
        Sort sort = new Insertion();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
