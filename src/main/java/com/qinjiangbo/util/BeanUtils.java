package com.qinjiangbo.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @date: 03/01/2017 11:34 AM
 * @author: qinjiangbo@github.io
 */
public class BeanUtils {

    /**
     * get bean by name and type, but the bean is processed
     *
     * @param name
     * @param clazz0
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<?> clazz0) {
        try {
            return (T) clazz0.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get bean by name and type if parameters provided
     *
     * @param name
     * @param clazz0
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<?> clazz0, Object... args) {
        Class<?>[] classes = new Class[args.length];
        Class<?>[] primitiveClasses = new Class[args.length];
        try {
            int i = 0;
            for (Object object : args) {
                classes[i] = object.getClass();
                primitiveClasses[i] = ReflectionUtils.convertToPrimitiveType(classes[i]);
                i++;
            }
            Constructor constructor = clazz0.getConstructor(classes);
            return (T) constructor.newInstance(args);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
