package com.qinjiangbo.exception;

/**
 * DuplicationBeanException is an exception for preventing declaring two same
 * classes, while the BeanFactory doesn't allow that
 *
 * @date: 05/01/2017 11:38 AM
 * @author: qinjiangbo@github.io
 */
public class ConflictedBeanException extends RuntimeException {

    public ConflictedBeanException(String message) {
        super(message);
    }

}
