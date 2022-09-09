package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.awt.*;
import java.util.List;

public class PageTest {
    /**
     * PageInfo{pageNum=1, pageSize=4, size=4, startRow=1, endRow=4, total=30, pages=8,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=30, pages=8, reasonable=false, pageSizeZero=false}[Emp{empId=1, empName='Yue Ka Fai', age=13, gender='M', deptId=757}, Emp{empId=2, empName='Zheng Zitao', age=101, gender='M', deptId=301}, Emp{empId=3, empName='Duan Yuning', age=632, gender='M', deptId=87}, Emp{empId=4, empName='Bonnie Warren', age=508, gender='F', deptId=900}], prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
     *
     *
     * pageNum：当前页的页码
     * pageSize：每页显示的条数
     * size：当前页显示的真实条数
     * total：总记录数
     * pages：总页数
     * prePage：上一页的页码
     * nextPage：下一页的页码
     * isFirstPage/isLastPage：是否为第一页/最后一页
     * hasPreviousPage/hasNextPage：是否存在上一页/下一页
     * navigatePages：导航分页的页码数
     * navigatepageNums：导航分页的页码，[1,2,3,4,5]
     */

    @Test
    public void testPage(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(1,4);
        List<Emp> list=mapper.selectByExample(null);
        //在查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo=new PageInfo<>(list,5);
        list.forEach(System.out::println);
        System.out.println(page);
        System.out.println(pageInfo);
    }

    @Test
    public void pagetest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询开启分页
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
         PageInfo<Emp> empPageInfo = new PageInfo<>(emps, 5);
        emps.forEach(System.out::println);
         System.out.println(page);
        System.out.println(empPageInfo);
    }
}
