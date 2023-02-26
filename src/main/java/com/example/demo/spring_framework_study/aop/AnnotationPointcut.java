package com.example.demo.spring_framework_study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointcut {
    @Before("execution(* com.example.demo.spring_framework_study.aop.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("---------注解：方法执行前---------");
    }

    @After("execution(* com.example.demo.spring_framework_study.aop.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("---------注解：方法执行后---------");
    }

    @Around("execution(* com.example.demo.spring_framework_study.aop.UserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前 class= "+jp.getTarget().getClass());

        System.out.println("签名:" + jp.getSignature());
        //执行目标方法proceed
        Object proceed = jp.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
        return proceed;
    }
}