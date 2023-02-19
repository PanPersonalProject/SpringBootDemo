package com.example.demo.spring_framework_study.beans;

import com.example.demo.spring_framework_study.beans.auto.Dog;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

public class Hello {
    @Autowired
    @Qualifier("student") //选择依赖注入的id
    Student student;

    @Autowired
    Dog dog;

    public Hello(HelloTwo helloTwo, HelloThree helloThree) {
//        System.out.println(helloTwo.toString()
//                + "\n"
//                + helloThree.toString());
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("依赖注入成功");
        student.show();
        dog.show();
    }

    static class HelloTwo {
        @Override
        public String toString() {
            return "HelloTwo";
        }
    }

    static class HelloThree {
        @Override
        public String toString() {
            return "HelloThree";
        }

    }
}
