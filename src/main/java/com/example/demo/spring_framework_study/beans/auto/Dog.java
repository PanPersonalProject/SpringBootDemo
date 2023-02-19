package com.example.demo.spring_framework_study.beans.auto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Dog")
@Scope("prototype")
// 相当于配置文件中 <bean id="Dog" class="当前注解的类"/>
public class Dog {
    @Value("jojo")
    // 相当于配置文件中 <property name="name" value="秦疆"/>
    String name;

    public void show() {
        System.out.println("dog "+name);
    }

}
