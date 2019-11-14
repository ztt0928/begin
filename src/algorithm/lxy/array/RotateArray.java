package algorithm.lxy.array;

/**
 * @author liuxinyi
 * @since 2019/11/14
 */
public class RotateArray {
    public static void rotate(int[][] array) {
        int n = array.length;
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = array[i][j];
                array[i][j] = array[n - 1 - j][i];
                array[n - 1 - j][i] = array[n - 1 - i][n - 1 - j];
                array[n - 1 - i][n - 1 - j] = array[j][n - 1 - i];
                array[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        rotate(array);
        for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length; j++) {
               System.out.print(array[i][j] + " ");
           }
            System.out.println();
        }
    }
}
