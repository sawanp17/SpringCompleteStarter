package com.example.demo.Repositories;

import com.example.demo.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findDepartmentByDepartmentId(Long id);
    Optional<Department> findDepartmentByNameIgnoreCase(String name);
}
