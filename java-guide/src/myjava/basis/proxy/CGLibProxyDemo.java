package myjava.basis.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实际调用方
 */
public class CGLibProxyDemo {
    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        /**
         * 重点！！！
         * 设置了三个属性： classLoader 、 superClass 、 callback
         */
        enhancer.setClassLoader(DuckDuckGo.class.getClassLoader());
        enhancer.setSuperclass(DuckDuckGo.class);   //这里直接用被代理类，不需要父类
        enhancer.setCallback(new MyMethodInterceptor());

        DuckDuckGo duckDuckGo = (DuckDuckGo) enhancer.create();
        duckDuckGo.search("dududu...");
    }
}

/**
 * 方法增强器
 */
class MyMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before--代码增强");

        /** 这里一定要注意，用的是  methodProxy  的  invokeSuper  方法，（虽然不知道为啥 */
        Object res = methodProxy.invokeSuper(o, objects);

        System.out.println("after--代码增强");
        return res;
    }
}

/**
 * 实际被增强的类/被代理的类
 */
class DuckDuckGo {
    /** 被代理的方法 */
    void search(String keyword){
        System.out.println(keyword);
    }
}