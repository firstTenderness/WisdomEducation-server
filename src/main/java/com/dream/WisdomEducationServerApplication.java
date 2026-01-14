package com.dream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.dream.mapper")
public class WisdomEducationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WisdomEducationServerApplication.class, args);
    }

}
