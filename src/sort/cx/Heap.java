package sort.cx;

//堆中某个节点的值总是大于等于其子节点的值，并且堆是一颗完全二叉树
//当前节点为k,则：
// 父节点： (k - 1) / 2,
// 左子节点：2 * k + 1，
// 右子节点：2 * k + 2
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    //上浮：当一个节点比父节点大，那么需要交换这个两个节点
    private void swim(int k) {
        while (k > 0 && less((k - 1) / 2, k)) {
            swap((k - 1) / 2, k);
            k = (k - 1) / 2;
        }
    }

    //下沉：当一个节点比子节点来得小
    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k + 1;
            //找到左右子树中最小的
            if (j < N - 1 && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
        }
    }

    public void insert(Comparable v) {
        heap[N++] = (T) v;
        swim(N);
    }

    public T delMax() {
        T max = heap[0];
        swap(0, N--);
        heap[N] = null;
        sink(0);
        return max;
    }
}
