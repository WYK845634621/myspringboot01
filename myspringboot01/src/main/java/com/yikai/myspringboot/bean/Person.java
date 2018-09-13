package com.yikai.myspringboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author wangyikai
 * @Date 2018/9/13 - 9:41
 */
@Component
@ConfigurationProperties(prefix = "persons")
public class Person {
    private  Integer id;
    private  String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {

    }

    public Person(Integer id, String name) {

        this.id = id;
        this.name = name;
    }
}
