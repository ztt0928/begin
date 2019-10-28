package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

//复杂度为 O(NlogN)
//非稳定排序
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    /*无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。
    一个更高效的方法是从右至左进行下沉操作，
    如果一个节点的两个节点都已经是堆有序，那么进行下沉操作可以使得这个节点为根节点的堆有序。
    叶子节点不需要进行下沉操作，可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。*/
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        //遍历所有的非叶子节点进行下沉操作
        for (int k = (N - 1) / 2; k >= 0; k--)
            sink(nums, k, N);
        //每次交换，将最大的放在N位置，然后对N之前的元素进行下浮操作
        while (N > 0) {
            swap(nums, 0, N--);
            sink(nums, 0, N);
        }
    }

    @Override
    public String type() {
        return "堆排序";
    }

    //下沉：当一个节点比子节点来得小
    private void sink(T[] nums, int k, int N) {
        while (2 * k < N) {
            //左子节点
            int j = 2 * k + 1;
            //存在右子节点，且右子节点比较大
            if (j < N - 1 && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
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
        Sort sort = new HeapSort();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));
    }
}
