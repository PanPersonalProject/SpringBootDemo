package com.example.demo;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//动态代理demo
public class ProxyTest {
    interface Player {
        void play(String url);

        void stop();
    }

    class TestPlayer implements Player {
        @Override
        public void play(String url) {

            System.out.println("play url " + url);
        }

        @Override
        public void stop() {
            System.out.println("play was stop ");
        }
    }

    @Test
    public void proxyTest() {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.setObj(new TestPlayer());
        Player player = (Player) Proxy.newProxyInstance(Player.class.getClassLoader(), new Class[]{Player.class}, myInvocationHandler);
        player.play("juejin.cn/post/6844903978342301709#heading-10");
        player.stop();
    }

    static class MyInvocationHandler implements InvocationHandler {
        private Object obj; //代理真实对象，在调用对象任何方法时，实际走invoke处理

        public void setObj(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("play")) {
                args[0] = "https://" + args[0];
            }

            Object object = method.invoke(obj, args);
            System.out.println("method is " + method.getName());

            return object;
        }
    }
}
