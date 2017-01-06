package com.qinjiangbo.util;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 03/01/2017 11:34 AM
 * @author: qinjiangbo@github.io
 */
public class ReflectionUtils {

    /**
     * find annotated methods
     *
     * @param clazz
     * @return
     */
    public static List<Method> findAnnotatedMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodList = new LinkedList<>();
        for (Method method : methods) {
            if (method.getAnnotations().length > 0) {
                methodList.add(method);
            }
        }
        return methodList;
    }
}
