package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuxinyi
 * @since 2019/11/22
 */
public class JdkProxy implements InvocationHandler{
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------before--------------");
        Object result = method.invoke(target, args);
        System.out.println("-------------after--------------");
        return result;
    }
}
