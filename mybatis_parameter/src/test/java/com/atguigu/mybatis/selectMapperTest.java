package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class selectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper =sqlSession.getMapper(SelectMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);

    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper =sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);

    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper =sqlSession.getMapper(SelectMapper.class);
        Integer count=mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserIdtoMap(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper =sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map=mapper.getUserByIdtoMap(8);
        //{password=123, gender=男, id=1, age=23, email=123456@qq.com, username=admin}
        System.out.println(map);
    }

    @Test
    public void testAllUserIdtoMap(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper =sqlSession.getMapper(SelectMapper.class);
//        List<Map<String,Object>> map=mapper.getAllUserToMap();
//        System.out.println(map);
        Map<String,Object> map=mapper.getAllUserToMap();
        System.out.println(map);
    }
}
