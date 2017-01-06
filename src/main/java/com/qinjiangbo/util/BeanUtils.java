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
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<?> clazz0, Class<T> target) {
        try {
            if (clazz0 == target) {
                return target.newInstance();
            } else {
                return (T) clazz0.newInstance();
            }
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
     * @param target
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<?> clazz0, Class<T> target, Object... args) {
        try {
            Class<?>[] classes = new Class[args.length];
            int i = 0;
            for (Object object : args) {
                classes[i] = object.getClass();
                i++;
            }
            if (clazz0 == target) {
                Constructor<T> constructor = target.getDeclaredConstructor(classes);
                return constructor.newInstance(args);
            } else {
                Constructor constructor = clazz0.getDeclaredConstructor(classes);
                return (T) constructor.newInstance(args);
            }
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
