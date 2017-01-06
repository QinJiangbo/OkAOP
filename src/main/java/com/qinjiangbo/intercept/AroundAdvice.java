package com.qinjiangbo.intercept;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @date: 05/01/2017 6:00 PM
 * @author: qinjiangbo@github.io
 */
public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return null;
    }
}
