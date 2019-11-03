package sort.cx;

public abstract class Sort<T extends Comparable<T>> {
    public abstract void sort(T[] nums);

    public abstract String type();

    //小于比较
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    //大于比较
    protected boolean more(T v, T w) {
        return v.compareTo(w) > 0;
    }

    //等于比较
    protected boolean equal(T v, T w) {
        return v.compareTo(w) == 0;
    }

    //交换
    protected void swap(T[] arr, int i, int j) {
        //method one
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        //method two
       /* arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[i];*/
        //method three
       /* arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];*/
    }
}
