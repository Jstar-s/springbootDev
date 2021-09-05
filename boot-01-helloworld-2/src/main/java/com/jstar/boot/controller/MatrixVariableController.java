package com.jstar.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/5 8:07 下午
 */

@RestController
public class MatrixVariableController {


    @GetMapping("/cars/{path}")
    /*
     *1.request path cars/sell;low=12;brand=a;brand=b
     *2.springboot 默认禁用矩阵变量功能
     * 3.手动开启原理，对于路径的解析，springboot使用UrlHelper进行解析
     * UrlHelper在WebMvcConfig中实现，我们实现这样一个类并重新放入修改了属性的UrlHelper来启用这个功能
     */
    public Map MatrixVariable(@MatrixVariable("low") Integer low,
                              @MatrixVariable("brand") List<String> brand,
                              @PathVariable("path") String path) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

}
