package com.atguigu.spring.contoller;

import com.atguigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//@Controller("controller")
@Controller
public class UserController {
    @Autowired
//    @Qualifier("UserServiceImpl")
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    public void saveUser(){
        userService.saveUser();
    }

}
