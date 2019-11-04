package algorithm.lxy;

/**
 * @author liuxinyi
 * @description 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @since 2019/11/4
 */
public class Fibona {
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                sum[i] = 1;
            } else {
                sum[i] = sum[i - 1] + sum[i - 2];
            }
        }
        return sum[n - 1];
    }

    public static void main(String[] args) {
        int n = Fibonacci(10);
        System.out.println(n);
    }
}
