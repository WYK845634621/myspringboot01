package com.yikai.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author wangyikai
 * @Date 2018/9/13 - 9:39
 */
@Controller
public class HCon {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }


    @RequestMapping("/success")
    public String success(Map map){
        map.put("any","王艺楷");

//        thymeleaf的路径是classpath:templates/*.html
        return  "success";
    }

}
