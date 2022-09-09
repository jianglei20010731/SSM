package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 若sql语句查询功能为多条时，一定不能以实体类类型作为方式的返回值
     * 否则会抛出异常TooManyResultException
     * 若sql语句查询结果为1条时，此时可以使用实体类型或list集合类型作为方法的返回值
     */
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有的用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 查询用户的总数量
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为一个map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdtoMap(@Param("id") Integer id);

    /**
     * 查询所有的用户信息为map集合
     * 若查询的数组有多余时，并且要将每天数据转换为map集合
     * 此时有两种方法
     * 1.将mapper接口方法的返回值设置为泛型时map的list集合
     * List<Map<String,Object>>
     * 结果：{{password=123, gender=男, id=1, age=23, email=123456@qq.com, username=admin}, {password=11111, gender=男, id=2, age=23, email=123456@qq.com, username=tom},
     * 2.可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey注解
     * 将查询的某个字段的值作为大的map的键
     * 结果:{1={password=123, gender=男, id=1, age=23, email=123456@qq.com, username=admin}, 2={password=11111, gender=男, id=2, age=23, email=123456@qq.com, username=tom},
     * @MapKey("id")
     * @return
     */
    //List<Map<String,Object>> getAllUserToMap();

    /**
     * {1={password=123, gender=男, id=1, age=23, email=123456@qq.com, username=admin}, 2={password=11111, gender=男, id=2, age=23, email=123456@qq.com, username=tom}, 4={password=22222, gender=男, id=4, age=23, email=123456@qq.com, username=jerry}, 5={password=333333, gender=男, id=5, age=23, email=123456@qq.com, username=jack}, 6={password=123456, gender=女, id=6, age=33, email=123@qq.com, username=root}, 7={password=123456, gender=男, id=7, age=23, email=123456@qq.com, username=admin}, 8={password=1112233, id=8, age=22, username=yamaha}}
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
