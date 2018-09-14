package com.yikai.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author wangyikai
 * @Date 2018/9/13 - 19:55
 */
@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public  String login(@RequestParam("username") String username, @RequestParam("password") String password, Map map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
//            防止表单的多次提交
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else {

            map.put("msg","用户名密码不正确");
            return  "login";

        }
    }
}
