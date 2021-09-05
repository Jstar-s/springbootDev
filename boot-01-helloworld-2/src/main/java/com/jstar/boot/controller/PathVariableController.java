package com.jstar.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/5 11:38 上午
 */
@RestController
public class PathVariableController {


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") String id, @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header
                                        ) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);
        map.put("userAgent",userAgent);
        map.put("headers", header);
        return map;
    }


    @GetMapping("/car2")
    public Map<String, Object> Car2(@RequestParam("age") String age,
                                    @RequestParam("inters")List<String> inters,
                                    @RequestParam Map<String, Object> params,
                                    @CookieValue("userTicket") String userTicket,
                                    @CookieValue("userTicket") Cookie cookie
                                    ) {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("age", age);
//        map.put("inters", inters);
//        map.put("params", params);
        map.put("userTicket", userTicket);
        map.put("cookie", cookie);
        System.out.println(cookie.getName());
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody String content) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

}
