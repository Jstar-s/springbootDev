package com.jstar.boot.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/3 9:32 上午
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private Pet pet;

}
