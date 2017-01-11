package com.qinjiangbo.core;

import com.qinjiangbo.annotation.stereotype.Component;
import com.qinjiangbo.annotation.stereotype.Controller;
import com.qinjiangbo.annotation.stereotype.Service;
import com.qinjiangbo.config.ContextConfiguration;
import com.qinjiangbo.core.factory.BeanFactory;
import com.qinjiangbo.util.BeanUtils;
import com.qinjiangbo.util.CollectionUtils;
import com.qinjiangbo.util.PackageUtils;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @date: 04/01/2017 10:14 PM
 * @author: qinjiangbo@github.io
 */
public class ApplicationContext {

    private ContextConfiguration contextConfig;
    private BeanFactory beanFactory;

    public ApplicationContext(ContextConfiguration contextConfig) {
        this.contextConfig = contextConfig;
        beanFactory = BeanFactory.getInstance();
        // scan packages
        scanPackages();
    }

    /**
     * scan the specified packages
     */
    private void scanPackages() {
        List<String> packages = contextConfig.getPackages();
        List<Class<? extends Annotation>> annotations = CollectionUtils.newLinkedList(
            Service.class, Controller.class, Component.class
        );
        for (String package0 : packages) {
            beanFactory.addClasses(PackageUtils.findClassList(package0, true, annotations));
        }
        beanFactory.mapClasses();
        beanFactory.clearClassList();
    }

    /**
     * get bean by name and type, but the bean is processed
     *
     * @param name
     * @param <T>
     * @return
     */
    public <T> T getBean(String name) {
        Class<?> clazz0 = beanFactory.getBean(name);
        return BeanUtils.getBean(name, clazz0);
    }

    /**
     * get bean by name and type if parameters provided
     *
     * @param name
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getBean(String name, Object... args) {
        Class<?> clazz0 = beanFactory.getBean(name);
        return BeanUtils.getBean(name, clazz0, args);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        ContextConfiguration contextConfiguration = new ContextConfiguration();
        contextConfiguration.setPackages("com.qinjiangbo.demo");
    }

}
