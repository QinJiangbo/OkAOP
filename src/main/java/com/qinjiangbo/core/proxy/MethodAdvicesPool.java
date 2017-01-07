package com.qinjiangbo.core.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date: 05/01/2017 9:12 PM
 * @author: qinjiangbo@github.io
 */
public class MethodAdvicesPool {

    private Map<String, List> methodAdvicesMap;
    private static MethodAdvicesPool INSTANCE;

    private MethodAdvicesPool(){
        methodAdvicesMap = new HashMap<>();
    }

    public static MethodAdvicesPool getInstance() {
        if (INSTANCE == null) {
            synchronized (MethodAdvicesPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MethodAdvicesPool();
                }
            }
        }
        return INSTANCE;
    }

}
