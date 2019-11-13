package algorithm.lxy.array;

/**
 * @author liuxinyi
 * @description 统计一个数字在排序数组中出现的次数。
 * @since 2019/11/13
 */
public class Frequency {
    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 4, 5};
        System.out.println(GetNumberOfK(array, 4));
    }
}
