package com.jstar.boot.controller;

import com.jstar.boot.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/6 10:28 下午
 */

@RestController
public class BeanController {

    @PostMapping("/saveuser")
    public Person saveUser(Person person) {
        return person;
    }

}
