package com.atguigu.spring.factory;

import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean是一个接口，需要创建一个类实现该接口
 * 其中有三个方法:
 * getObject():通过一个对象交给IOC容器管理
 * getObjectType():设置所提供对象的类型
 * issingLeton():所提供得到对象是否案例
 * 当把FactoryBean的实现类配置为bean时，会将当前类中得到getObject()所返回的对象交给IOC容器管理
 */

public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
