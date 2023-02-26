package com.example.demo.spring_framework_study.aop;

public class DiyPointcut {
    public void before(){
        System.out.println("---------diy方法执行前---------");
    }
    public void after(){
        System.out.println("---------diy方法执行后---------");
    }
}