package com.example.demo.spring_framework_study.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Hello {
    @Autowired
    Student student;
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
