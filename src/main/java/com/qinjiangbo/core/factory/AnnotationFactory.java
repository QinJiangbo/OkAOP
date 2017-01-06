package com.qinjiangbo.core.factory;

import com.qinjiangbo.annotation.After;
import com.qinjiangbo.annotation.Around;
import com.qinjiangbo.annotation.Before;
import com.qinjiangbo.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * @date: 05/01/2017 8:16 PM
 * @author: qinjiangbo@github.io
 */
public class AnnotationFactory {

    private Map<String, Class<? extends Annotation>> annotationMap;
    private static AnnotationFactory INSTANCE;

    private AnnotationFactory(){
        annotationMap = initMap();
    }

    public static AnnotationFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (AnnotationFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AnnotationFactory();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * initialize the annotation map
     * @return
     */
    private Map<String, Class<? extends Annotation>> initMap() {
        List<String> keys = CollectionUtils.newArrayList("Before", "Around", "After");
        List<Class<? extends Annotation>> values =
                CollectionUtils.newArrayList(Before.class, Around.class, After.class);
        return CollectionUtils.newHashMap(keys, values);
    }

}
