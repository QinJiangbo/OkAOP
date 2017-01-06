package com.qinjiangbo.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @date: 03/01/2017 11:34 AM
 * @author: qinjiangbo@github.io
 */
public class AnnotationUtils {

    /**
     * filter annotated methods by given annotations
     *
     * @param methodList
     * @param annotations
     * @return
     */
    public static List<Method> filterAnnotatedMethods(List<Method> methodList, List<Class<? extends Annotation>> annotations) {
        List<Method> methodList0 = new LinkedList<>();
        for (Method method : methodList) {
            for (Class<? extends Annotation> annotation : annotations) {
                if (method.isAnnotationPresent(annotation)) {
                    methodList0.add(method);
                    break;
                }
            }
        }
        return methodList0;
    }
}
