package com.qinjiangbo.core.factory;

import com.qinjiangbo.annotation.stereotype.Aspect;
import com.qinjiangbo.exception.ConflictedBeanException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @date: 03/01/2017 11:34 AM
 * @author: qinjiangbo@github.io
 */
public class BeanFactory {

    private static BeanFactory INSTANCE = null;
    private List<Class<?>> classList = new LinkedList<>();
    private Map<String, Class<?>> classMap = new HashMap<>();

    private BeanFactory() {
    }

    /**
     * get the singleton instances
     *
     * @return
     */
    public static BeanFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (BeanFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BeanFactory();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * add scanned classes
     */
    public void addClasses(List<Class<?>> classList) {
        this.classList.addAll(classList);
    }

    /**
     * map the classes
     */
    public void mapClasses() {
        for (Class<?> clazz : classList) {
            String className = clazz.getSimpleName().substring(0, 1).toLowerCase()
                    + clazz.getSimpleName().substring(1);
            if (classMap.containsKey(className)) {
                throw new ConflictedBeanException(className + " for class " + clazz.getName()
                        + " conflicts with " + classMap.get(className).getName());
            }
            classMap.put(className, clazz);
        }
    }

    /**
     * get bean by name
     *
     * @param name
     * @return
     */
    public Class<?> getBean(String name) {
        return classMap.get(name);
    }

    /**
     * clear the class list, waiting for GC
     */
    public void clearClassList() {
        classList = null;
    }

    /**
     * filter Aspect classes
     *
     * @return
     */
    public List<Class<?>> filterAspectJs() {
        List<Class<?>> classes = (List<Class<?>>) classMap.values();
        List<Class<?>> aspectjs = new LinkedList<>();
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(Aspect.class)) {
                aspectjs.add(clazz);
            }
        }
        return aspectjs;
    }
}
