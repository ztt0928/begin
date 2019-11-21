package leetcode;

import java.util.Stack;

/**
 * @author liuxinyi
 * @description 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * @since 2019/11/19
 */
public class Number2 {
    public static int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        Stack<Integer> number = new Stack<>();
        Stack<String> symbol = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                symbol.push(tokens[i]);
                number.push(addNumber(number.pop(), number.pop(), symbol.pop()));
            } else if (tokens[i].equals("-")) {
                symbol.push(tokens[i]);
                number.push(addNumber(number.pop(), number.pop(), symbol.pop()));
            } else if (tokens[i].equals("*")) {
                symbol.push(tokens[i]);
                number.push(addNumber(number.pop(), number.pop(), symbol.pop()));
            } else if (tokens[i].equals("/")) {
                symbol.push(tokens[i]);
                number.push(addNumber(number.pop(), number.pop(), symbol.pop()));
            } else {
                number.push(Integer.parseInt(tokens[i]));
            }
        }
        return number.pop();
    }

    public static int addNumber(int a, int b, String symbol) {
        switch (symbol) {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                if (b == 0) {
                    return 0;
                } else {
                    return b / a;
                }
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] array = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(array));
    }
}
