package com.qinjiangbo.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @date: 12/01/2017 1:40 PM
 * @author: qinjiangbo@github.io
 */
@Aspect
@Component
public class BookAspect {

    @Before("execution(* com.qinjiangbo.test.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName()
                + "(" + Arrays.asList(joinPoint.getArgs()) + ")");
    }
}
