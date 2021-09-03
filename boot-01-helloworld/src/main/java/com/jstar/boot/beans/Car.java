package com.jstar.boot.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/3 10:30 上午
 */

/**
 * only container module can have springboot functions
 *
 */
//@Component
// check properties file to get value with specific prefix
@ConfigurationProperties(prefix = "mycar")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    private String brand;
    private Integer price;





}
