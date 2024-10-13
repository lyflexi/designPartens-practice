package org.lyflexi.proxy.dynamic_proxy_cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理业务实现
 * 在此增加增强处理
 */
public class DaoMethodInterceptor implements MethodInterceptor {

    /**
     * 代理逻辑方法,：cglib这里的几个参数与jdk动态代理h.invoke的参数稍有不同，注意区分
     * @param target 代理对象
     * @param method 方法对象
     * @param args 方法参数
     * @param methodProxy 方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = execute(target,method,args,methodProxy);
        return  result;
    }

    /**
     * 可以定制，看我们自己的需求来定；
     * 可以增加参数、可以调用目标方法（代理目标对象而不是接口）、调用目标方法前后织入增强处理等等
     *
     * 本示例只是展示流程
     * @param args
     * @return
     */
    private Object execute(Object target,Method method,Object[] args,MethodProxy methodProxy) {
        System.out.println("cglib前置操作...");

        try {
//            //原方法执行方式1:
            Object invokeValue1 = methodProxy.invokeSuper(target, args);//执行被代理方法
            System.out.println("原方法执行方式1:methodProxy.invokeSuper(target, args);的结果："+invokeValue1);
             //下面这种会出现死循环调用 TODO
//            method.setAccessible(true);
//            Object invokeValue2 = method.invoke(target, args);
//            System.out.println("原方法执行方式2:method.invoke(target, args);的结果："+invokeValue2);

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        // 强行修改方法的返回值，相当于增强效果
        int returnValue = 1;
        System.out.println("cglib后置操作...");
        return returnValue;
    }
}
