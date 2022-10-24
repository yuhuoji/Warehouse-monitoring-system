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

        User userBean = new User();
        /* 用foreach 判断用户是否合法 */
        boolean userIsValid = false;
        List<User> list = userService.selectAllUser();
        System.out.println("user = " + user.toString() + "list = " + list.toString());
        for (User userTemp : list) {
            if (user.getUserName().equals(userTemp.getUserName()) && user.getUserPassword().equals(userTemp.getUserPassword())) {
                userIsValid = true;
                userBean.setUserId(userTemp.getUserId());
                userBean.setUserName(userTemp.getUserName());
                userBean.setUserPassword(userTemp.getUserPassword());
//                System.out.println("The user : userId = " + userTemp.getUserId() + ", UserName = " + userTemp.getUserName() + ", UserPassword = " + userTemp.getUserPassword() + ".");
                break;
            }
        }
        System.out.println("login check over");
        /* 根据查询向前台返回结果 */
        if (userIsValid) {
            return Result.success(userBean);
        } else {
            return Result.error("0", "The user does not exist.");
        }

    }



}
