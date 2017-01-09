package com.qinjiangbo.demo;

import com.qinjiangbo.annotation.stereotype.Component;

/**
 * @date: 09/01/2017 8:54 AM
 * @author: qinjiangbo@github.io
 */
@Component
public class Com {

    private String name;
    private Integer age;

    public Com(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
