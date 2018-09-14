package com.yikai.myspringboot.controller;

import com.yikai.myspringboot.dao.DepartmentDao;
import com.yikai.myspringboot.dao.EmployeeDao;
import com.yikai.myspringboot.entities.Department;
import com.yikai.myspringboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @Author wangyikai
 * @Date 2018/9/14 - 15:03
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
//        thymeleaf默认就会拼串
        return  "emp/list";
    }

    @GetMapping("/emp")
    public  String toAddPage(Model model){
//        来到添加页面查出所有部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
}