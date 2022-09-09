package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 1.通过servletAPI获取
 * 只需要在控制器方法的形参位置设置HttpServletRequest类型的形参，
 * 就可以在控制器方法中使用request对象获取请求参数
 *
 * 2.通过控制器方法的形参获取请求参数
 * 只需要在控制器方法的形参位置，来设置一个形参的名字要和请求参数的名字一致即可
 *
 * 3.@RequestParam:将请求参数和控制器方法的形参绑定
 * @RequestParam注解的三个属性:value,required,defaultValue
 * value:设置和形参绑定的请求参数的名字
 * required:设置是否必须传输value所对应的请求参数
 * 默认值为true，表示value所对应的请求参数必须传输，否则页面报错:
 * 400-Required String parameter 'userName' is not present
 * 若设置为false，则表示value所对应的请求参数不是必须传输，若未传输，则形参值为bull
 * defaultValue:设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值无关
 *
 * 4.@RequestHeader:将请求头信息的控制器方法的形参绑定
 *
 * 5.@CookieValue:将cookie数据和控制器方法的形参进行绑定
 *
 * 6.通过控制器方法的实体类类型的形参获取请求参数
 * 需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的名字一致
 * 可以通过实体类类型的形参获取请求参数
 *
 * 7.解决获取请求此参数的乱码问题
 * 在web，xml中配置Spring的编码过滤器CharacterEncodingFilter
 * SpringMVC中处理编码的过滤器一定要配置到其他过滤器之前，否则无效
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServlet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = false, defaultValue = "hello") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jssessionId

    ) {
        System.out.println("JSESSIONID:"+jssessionId);
        System.out.println("referer:"+referer);
        System.out.println("username:" + username + ",password" + password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
