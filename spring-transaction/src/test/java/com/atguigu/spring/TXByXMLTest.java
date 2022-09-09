package com.atguigu.spring;

import com.atguigu.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 声明式事务的配置步骤:
 * 1.在spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 在需要被事务管理的方法上，添加@Transactional注解，该方法就会进行事务管理
 * @Transactional注解
 * 1.标识在方法上
 * 2.标识在类上，则类中所有得到方法都会被事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TXByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
//        bookController.checkout(1,new Integer[]{1,2});
    }
}
//注意：基于xml实现的声明式事务，必须引入aspectJ的依赖
