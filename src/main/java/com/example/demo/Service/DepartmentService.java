package com.example.demo.Service;

import com.example.demo.Entities.Department;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Repositories.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
    @Autowired
    DepartmentRepository departmentRepository;


    public Department addDepartment(final Department department) {
        LOGGER.info("inside addDepartment()");
        return departmentRepository.save(department);
    }


    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(final Long id) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = departmentRepository.findDepartmentByDepartmentId(id);
        if (departmentOptional.isEmpty()){
            throw new DepartmentNotFoundException("Department with given ID not found...");
        }
        return departmentOptional.get();
    }

}
