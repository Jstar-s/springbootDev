package com.jstar.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/5 1:21 下午
 */
@Controller
public class RequestAttributeController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        return "forward:/success";

    }


    @GetMapping("/params")

    //无论如参是map， model， 数据都会放在请求域中
    public String params(Map<String, Object> map,
                         Model model,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        map.put("map", "aaa");
        model.addAttribute("model", "bbb");
        Cookie cookie = new Cookie("cookie", "ccc");
        response.addCookie(cookie);
        return "forward:/success";
    }
    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) Integer code,
                       HttpServletRequest request
                       ) {
        HashMap<String, Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        Object map1 = request.getAttribute("map");
        Object model = request.getAttribute("model");
        Object cookie = request.getAttribute("cookie");
        map.put("msg1", msg1);
        map.put("msg", msg);
        map.put("code", code);
        map.put("map", map1);
        map.put("model", model);
        map.put("cookie", cookie);
        return map;
    }


}
