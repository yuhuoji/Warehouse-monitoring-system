package com.bupt.springboot.mapper;
/* D层：dao层也叫mapper层，数据持久层, 直接操作数据库中的数据，针对数据的增删改查。 */
/* Mapper层 Dao(DAL)数据访问层 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bupt.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Mapper层只有接口，无impl， 具体实现由框架进行。 与数据库进行交互，进行JavaBean的组装 */
/* @Repository 与 @Mapper的区别 */
@Mapper
/* 继承BaseMapper则mybatisPlus可以自动写好增删改查 */
public interface UserMapper extends BaseMapper<User> {

    /* select all from userinfo */
    @Select("select * from userinfo")
    List<User> login();

}
