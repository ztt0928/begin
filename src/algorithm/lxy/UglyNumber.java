package algorithm.lxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxinyi
 * @since 2019/11/12
 * @description 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    public static int GetUglyNumber_Solution(int index) {
        List<Integer> array = new ArrayList<>(index - 1);
        List<Integer> ugly = new ArrayList<>();
        ugly.add(2);
        ugly.add(3);
        ugly.add(5);
        array.add(1);
        int num = 2;
        while (array.size() < index) {
            List<Integer> primeNumber = new ArrayList<>();
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    primeNumber.add(i);
                }
            }
            primeNumber.removeAll(ugly);
            if (primeNumber.size() == 0) {
                array.add(num++);
            }
        }
        return array.get(array.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(8));
    }
}
