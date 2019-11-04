package sort.cx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//复杂度为 O(NlogN)
//非稳定排序
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    @Override
    public String type() {
        return "快排";
    }

    private void sort(T[] nums, int l, int h) {
        if (l >= h)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    //洗牌
    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
    }

    //切分
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            //从左往右找到第一个比v大的数
            while (less(nums[++i], v) && i != h) ;
            //从右到左找到第一个比v小的数
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        // 将 v 放到正确的位置（左子数组小于等于 v,右子数组大于等于 v）
        swap(nums, l, j);
        return j;
    }

    //找出数组的第 k 个元素,时间复杂度： (N+N/2+N/4+..)  <2N
    public T select(T[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);

            if (j == k) {
                return nums[k];

            } else if (j > k) {
                h = j - 1;

            } else {
                l = j + 1;
            }
        }
        return nums[k];
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
        Sort sort = new QuickSort();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
