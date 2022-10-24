package com.bupt.springboot;
/* springboot启动类，提供接口，前台可以访问 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 如果有多个mapper文件的话，@MapperScan指定要扫描的mapper位置*/
@SpringBootApplication
@MapperScan("com.bupt.springboot.mapper")
public class SpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
