package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**#{}的本质是占位符赋值，${}的本质是字符串拼接
 * mybatis获取参数的两种方式#{}、${}
 * 1.若mapper接口的字面量为单个类型可以用#{}和${}两种方式，以任意内容获取参数值，注意${}的单引号问题
 * 2.若mapper接口方法的参数为多个的字面量类型，此时MyBatis会将参数放在Map集合中，以两种方法存储数据
 * a>以arg0，arg1..为键，以参数为值
 * b>以param1，param2..为键，以参数为值
 * 因此，只需要通过#{}和${}访问map集合的键，就可以获取对应的值
 * 一定要注意${}的单引号问题
 * 3.若mapper接口的字面量为map集合类型的参数
 * 通过#{}和${}来访问map的键，注意${}的单引号问题
 * 4.若mapper接口方法的参数为实体类类型的参数
 * 只需要通过#{}和${}访问实体类中的属性名，就可以获取相对应的属性值，注意${}的单引号问题
 * 5.可以在mapper接口方法的参数上设置@Param注解
 * 此时MyBatis会将这些参数放在map中，以两种方式进行存储
 * a>以param注解的value属性值为键，以参数为值
 * b>以param1，param2..为键，以此参数为值
 * 只需要通过#{}和${}访问map集合的键，就可以获取相对于的值，一定要注意${}的单引号问题
 */
public interface UserMapper {
    User getUserById();

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 验证登录（以map集合作为参数）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 添加用户信息
     * @param user
     */
    void insertUser(User user);

    /**
     *验证登录（使用@param）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
