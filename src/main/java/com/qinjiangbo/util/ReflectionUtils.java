package com.qinjiangbo.util;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    /**
     * get the primitive type of some class
     * @param clazz
     * @return
     */
    public static Class<?> convertToPrimitiveType(Class<?> clazz) {
        List<String> classNames = CollectionUtils.newArrayList(
                "java.lang.Boolean","java.lang.Character","java.lang.Byte",
                "java.lang.Short","java.lang.Integer","java.lang.Long",
                "java.lang.Float","java.lang.Double","java.lang.Void"
        );
        List<Class<?>> clazzList = CollectionUtils.newArrayList(
                boolean.class, char.class, byte.class, short.class,
                int.class, long.class, float.class, double.class, void.class
        );
        Map<String, Class<?>> classMap = CollectionUtils.newHashMap(classNames, clazzList);
        String clazzName = clazz.getName();
        return classMap.get(clazzName);
    }
}
