package com.example.demo.spring_framework_study.aop;

public class UserServiceImpl implements UserService{
    @Override
    public boolean add() {
        System.out.println("增加用户");
        return true;
    }
    @Override
    public void delete() {
        System.out.println("删除用户");
    }
    @Override
    public void update() {
        System.out.println("更新用户");
    }
    @Override
    public void search() {
        System.out.println("查询用户");
    }
}