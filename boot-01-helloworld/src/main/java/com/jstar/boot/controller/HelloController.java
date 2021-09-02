package com.jstar.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/2 9:57 下午
 */

// @RestController = @Controller + @ResponseBody
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String handle01() {
        return "Hello SpringBoot";
    }





}
