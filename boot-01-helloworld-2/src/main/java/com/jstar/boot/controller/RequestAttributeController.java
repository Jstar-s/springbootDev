package com.jstar.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request
                       ) {
        HashMap<String, Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        map.put("msg1", msg1);
        map.put("msg", msg);
        map.put("code", code);
        return map;
    }


}
