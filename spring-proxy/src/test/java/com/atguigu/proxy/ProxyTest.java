package com.atguigu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy(){

        /**
         * 动态代理有两种:
         * 1.jdk动态代理,要求必须有接口,最终生成的代理类和目标类实现相同的目标接口
         * 在com.sun.proxy的包下,类名为proxy2
         * 2.cglib动态代理,会继承生成得到目标类,并且和目标类在相同的包下
         */

//        CalculatorStaticProxy proxy=new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,2);
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        Calculator proxy= (Calculator) proxyFactory.getProxy();
        proxy.add(1,2);
    }
}
