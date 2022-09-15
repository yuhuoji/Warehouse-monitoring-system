package com.bupt.springboot.service;

/* service层的接口 */

import com.bupt.springboot.entity.User;
import kotlin.Result;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

//    int deleteById(Integer id);

    /* 定义接口 */
    public List<User> login();

}
