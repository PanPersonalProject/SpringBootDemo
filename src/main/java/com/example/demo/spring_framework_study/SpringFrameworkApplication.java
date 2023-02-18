package com.example.demo.spring_framework_study;

import com.example.demo.spring_framework_study.beans.Hello;
import com.example.demo.spring_framework_study.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringFrameworkApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_framework_study/application_context.xml");
//		getStudent(context);
		getHello(context);
	}

	private static void getStudent(ApplicationContext context) {
		Student student = context.getBean("student", Student.class);
		student.show();
	}
	private static void getHello(ApplicationContext context) {
		Hello hello = context.getBean("hello", Hello.class);
		hello.show();
	}

}
