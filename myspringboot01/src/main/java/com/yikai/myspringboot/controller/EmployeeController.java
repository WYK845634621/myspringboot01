package com.yikai.myspringboot.controller;

import com.yikai.myspringboot.dao.DepartmentDao;
import com.yikai.myspringboot.dao.EmployeeDao;
import com.yikai.myspringboot.entities.Department;
import com.yikai.myspringboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

//    查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
//        thymeleaf默认就会拼串
        return  "emp/list";
    }

//    来到员工添加页面
    @GetMapping("/emp")
    public  String toAddPage(Model model){
//        来到添加页面查出所有部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

//  进行员工添加操作    html页面的入参值必须与实例对象的属性值一致
    @PostMapping("/emp")
    public  String addEmp(Employee employee){
        employeeDao.save(employee);
//        /代表当前项目
        return "redirect:/emps";
    }

//    来到修改页面  查出当前员工 并进行回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
//        add是一个添加和修改二合一的页面
        return "emp/add";
    }

    @PutMapping("/emp")
    public  String update(Employee employee){
        System.out.println("要修改的员工是: " + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

}
