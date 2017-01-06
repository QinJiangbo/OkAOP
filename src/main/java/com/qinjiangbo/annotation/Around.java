package com.qinjiangbo.annotation;

import java.lang.annotation.*;

/**
 * @date: 03/01/2017 3:19 PM
 * @author: qinjiangbo@github.io
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Around {
    String value();
}
