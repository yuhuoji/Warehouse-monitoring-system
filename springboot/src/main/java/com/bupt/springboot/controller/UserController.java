package com.bupt.springboot.controller;

/*
 * U层，负责接受用户的请求，展示数据，获取用户通过界面所输入的数据。
 * Controller层 Controller（UI）界面控制层
 * Result返回前台数据的包装类
 * */

import com.bupt.springboot.common.Result;
import com.bupt.springboot.entity.User;

import com.bupt.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 跨域请求 */
@CrossOrigin
/* 返回 javabean ---> json */
@RestController
/* 统一的路由, 后台接口的路由是/user */
@RequestMapping("/user")
public class UserController {

    /* @Autowired自动组装，自动在后台匹配实现类，自动new实例化 */
    @Autowired
    /* Controller层调用Service层 */
    private UserService userService; /* service其实是UserService的具体实现，即UserServiceImpl */

    /* value是页面的请求， 可以写多个value = {"/other", "/other2", "/other3"} */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    /* 后端使用@RequestBody注解；将要取得的参数列表封装为一个实体类 */
    public Result<?> login(@RequestBody User user) {
        System.out.println("login(@RequestBody User user)");

        int userId = -1;

        /* 用foreach 判断用户是否合法 */
        boolean userIsValid = false;
        List<User> list = userService.login();
        for (User userTemp : list) {
            if (user.getUsername().equals(userTemp.getUsername()) && user.getPassword().equals(userTemp.getPassword())) {
                userIsValid = true;
                userId = user.getUserId();
                break;
            }
        }
        System.out.println("userId = " + userId + ", username = " + user.getUsername() + ", password = " + userIsValid + ".");
        /* 根据查询向前台返回结果 */
        if (userIsValid) {
            return Result.success();
        } else {
            return Result.error("0", "The user does not exist.");
        }

    }

    /*   *//* 请求方法为get,返回所有用户信息到前台 *//*
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }*/
}
