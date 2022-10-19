package com.bupt.springboot;
/* 测试类 */
import com.bupt.springboot.entity.User;
import com.bupt.springboot.mapper.UserMapper;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
/* 使用@SpringBootTest注解进行单元测试 */
@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    UserMapper userMapper;

    /* */
    @DisplayName(" 测试mybatisPlus操作 ")
//    @Test
    void contextLoads() {
        if (false){
        /* TEST : List<List> */
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        List<String> stringList = new ArrayList<>();
        stringList.add("No1");
        stringList.add("No2");
        List<List> list = new ArrayList<>();
        list.add(integerList);
        list.add(stringList);
        System.out.println("list = " + list);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        }

        if (false){
        /* select， selectList获取所有的用户信息 */
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);

        /* update */
        User updateUser = new User(111, "updater1", "updater1");
        /* update返回值为1说明返回成功, updateById根据id来更新
        * 详见CSDN */
        int update = userMapper.updateById(updateUser);
        System.out.println("update = " + update);

//        insert
        User insertUser = new User();
        insertUser.setUserName("insert");
        insertUser.setUserPassword("insert password");
        int insert = userMapper.insert(insertUser);
        System.out.println("insert = " + insert);
/*

//        delete
        int delete = userMapper.deleteById(0);
        System.out.println("delete = " + delete);

*/
        }

    }

}
