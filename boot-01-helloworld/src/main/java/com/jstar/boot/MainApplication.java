package com.jstar.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jstar
 * @version 1.0
 *
 * 主程序类
 * @date 2021/9/2 9:55 下午
 */

@SpringBootApplication   //this is a Springboot Application
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
