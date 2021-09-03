package com.jstar.boot.controller;

import com.jstar.boot.beans.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/2 9:57 下午
 */

// @RestController = @Controller + @ResponseBody
@Slf4j
@RestController
public class HelloController {


    @Autowired
    private Car car;

    @RequestMapping("/hello")
    public String handle01() {
        log.info("hello request");
        return "Hello SpringBoot";
    }

    @RequestMapping("getPathParam")
    // http://localhost:8888/getPathParam?name=tom
    //@RequestParam("name")从url中读取变量的值
    public String handle02(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @RequestMapping("/car")
    public Car car() {
        return car;
    }





}
