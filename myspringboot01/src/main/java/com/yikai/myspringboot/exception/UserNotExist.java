package com.yikai.myspringboot.exception;

/**
 * @Author wangyikai
 * @Date 2018/9/15 - 21:13
 */
public class UserNotExist extends RuntimeException{
    public UserNotExist(){
        super("用户名不存在");
    }
}
