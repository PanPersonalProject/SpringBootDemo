package com.example.demo;

import com.example.demo.bean.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")  //注释确保将/greeting请求映射greeting()方法。http://localhost:8080/greeting?name=Pan
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // 默认Jackson自动将对象转为json返回,转换器MappingJackson2HttpMessageConverter
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
