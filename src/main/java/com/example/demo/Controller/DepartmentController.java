package com.example.demo.Controller;

import com.example.demo.Entities.Department;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/get/all")
    public List<Department> getAllDepartments(){
        return departmentService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/getByName/{name}")
    public Department getDepartmentById(@PathVariable("name") String name) throws DepartmentNotFoundException {
        return departmentService.getDepartmentByName(name);
    }

}
