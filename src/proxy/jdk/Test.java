package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author liuxinyi
 * @since 2019/11/22
 */
public class Test {
    public static void main(String[] args) {
        Fruit fruit = (Fruit) Proxy.newProxyInstance(Fruit.class.getClassLoader(), Apple.class.getInterfaces(), new JdkProxy(new Apple()));
        fruit.getName();
    }
}
