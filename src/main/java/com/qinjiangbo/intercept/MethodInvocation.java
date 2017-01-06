package com.qinjiangbo.intercept;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @date: 05/01/2017 9:37 PM
 * @author: qinjiangbo@github.io
 */
public class MethodInvocation {

    private Method method;
    private Object[] arguments;
    private Object target;

    /**
     * invoke the method
     * @return
     */
    public Object proceed() {
        Object retVal = null;
        try {
            retVal = method.invoke(target, arguments);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
