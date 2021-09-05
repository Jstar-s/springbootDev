package com.jstar.boot.controller;

import com.jstar.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/4 2:05 下午
 */
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }

    @RequestMapping(value = "/user")
    public String userGET() {
        System.out.println("REST post");
        return "get";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String userDelete() {
        System.out.println("REST delete");
        return "delete";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String userPut() {
        System.out.println("REST put");
        return "put";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String userPOST() {
        System.out.println("REST post");
        return "post";
    }

}
