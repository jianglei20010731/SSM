package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 20, "男");
        List<Emp> list = mapper.getEmpByCondition(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 20, "男");
        List<Emp> list = mapper.getEmpByChoose(emp);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "honda", 20, "男");
        Emp emp2 = new Emp(null, "suzuki", 21, "男");
        Emp emp3 = new Emp(null, "kawasaki", 22, "男");
        List<Emp> list=Arrays.asList(emp1,emp2,emp3);
        mapper.insertMoreEmp(list);

    }

    @Test
    public void testDeleteMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds= new Integer[]{6,7};
        mapper.deleteMoreEmp(empIds);

    }
}