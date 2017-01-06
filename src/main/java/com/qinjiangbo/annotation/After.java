package com.qinjiangbo.annotation;

import java.lang.annotation.*;

/**
 * @date: 03/01/2017 11:12 AM
 * @author: qinjiangbo@github.io
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface After {
    String value();
}
