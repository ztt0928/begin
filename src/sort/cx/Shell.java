package sort.cx;

import java.util.Arrays;
import java.util.Scanner;

//时间复杂度	O(n^2)
//不稳定排序
public class Shell<T extends Comparable<T>> extends Sort<T> {

    /*@Override
    public void sort(T[] nums) {
        for(int gap=nums.length;gap>0;gap/=2){
            for(int i=gap;i<nums.length;i++){
                T temp=nums[i];
                int j=i-gap;
                for(;j>=0&&less(temp,nums[j]);j-=gap){
                    nums[j+gap]=nums[j];
                }
                nums[j+gap]=temp;
            }
        }
    }*/

    @Override
    public void sort(T[] nums) {
        //增量gap
        int gap = 1;
        //Knuth 增量序列
        while (gap < nums.length / 3) {
            gap = 3 * gap + 1;
        }
        //逐步缩小增量
        for (; gap > 0; gap /= 3) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < nums.length; i++) {
                T temp = nums[i];
                int j = i - gap;
                for (; j >= 0 && less(temp, nums[j]); j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = temp;
            }
        }
    }

    @Override
    public String type() {
        return "希尔排序";
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
        Sort sort = new Shell();
        sort.sort(number);
        System.out.println(sort.type() + "结果：");
        //[2, 2, 5, 11, 22, 23, 40, 45, 59, 539]
        System.out.println(Arrays.toString(number));

    }
}
