package sort.cx;

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h) {
        int left = l, right = m + 1;
        for (int i = l; i <= h; i++) {
            aux[i] = nums[i];
        }
        for (int i = l; i <= h; i++) {
            if (left > m) {
                //左部分已经遍历完，直接 把右边剩余部分加入
                nums[i] = aux[right++];
            } else if (right > h) {
                //右部分已经遍历完，直接 把左边剩余部分加入
                nums[i] = aux[left++];
            } else if (less(aux[left], aux[right])) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }

    @Override
    public String type() {
        return "归并排序";
    }

}
