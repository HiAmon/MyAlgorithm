package myjava.basis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyDemo {
    /**
     * ▲ 最终的实际调用方
     * @param args
     */
    public static void main(String[] args) {
        //InvocationHandler 调用处理程序
        Google google = new Google();

        google.getClass();
        Class goz = Google.class;

        /**
         * Proxy类提供的创建代理对象的方法： ⬇⬇⬇
         */
        Search googleProxy = (Search)Proxy.newProxyInstance(
                /**目标类的类加载器*/
                google.getClass().getClassLoader(),
                /**代理需要实现的接口，可指定多个*/
                google.getClass().getInterfaces(),
                /**代理对象对应的自定义 InvocationHandler*/
                new MyInvocationHandler(google)
        );

        googleProxy.searchGoogle("hhh");

    }
}

/**
 * ▲ 调用处理程序，用来做 调用 的处理 的
 */
class MyInvocationHandler implements InvocationHandler{

    /** 被代理对象 */
    private final Object target;

    /**
     * 此调用处理程序的构造方法，需要传入被代理对象
     * @param target
     */
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  throws InvocationTargetException, IllegalAccessException {
        System.out.println("before method:" + method.getName());
        Object res = method.invoke(target,args);
        System.out.println("after method:" + method.getName());
        return res;
    }
}

/**
 * 要有个接口（不知道为啥）
 */
interface Search{
    void searchGoogle(String keyword);
}

/**
 * ▲ 被代理类
 */
class Google implements Search {

    @Override
    public void searchGoogle(String keyword) {
        System.out.println(keyword);
    }
}