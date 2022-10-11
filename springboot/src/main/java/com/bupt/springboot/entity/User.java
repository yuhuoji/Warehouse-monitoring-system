package com.bupt.springboot.entity;
/* model层也叫pojo层或者entity层，一般数据库的一张表对应一个pojo层，并且表中所有字段都在pojo层都一一对应 */
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* mybatis plus, 指定对应的表。mybatisPlus查找数据库默认规则是驼峰映射，也可以注明TableName */
@TableName("userinfo")
/* lombok插件根据@Data注解自动识别User类里的枚举类型产生类的get、set、equals、hashCode、canEqual、toString方法 */
@Data
/* 无参构造和全参构造 */
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /* @TableId注解是专门用在主键上的注解, 如果数据库中的主键字段名和实体中的属性名，不一样且不是驼峰之类的对应关系, value要写属性名???, AUTO设置id自增,
    * @TableId(value=“数据库主键字段”, type = IdType.六种类型之一) */
    @TableId(value = "user_id", type = IdType.AUTO)
    /* JavaBean里用小驼峰， 对应数据库里的下划线命名， orm自动将关系数据库里的每一行数据转换成一个User，attribute也同时自动对应转换 */
    private Integer userId;
    private String username;
    private String password;

}
