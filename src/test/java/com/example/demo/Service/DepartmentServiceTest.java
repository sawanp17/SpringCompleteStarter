package com.example.demo.Service;

import com.example.demo.Entities.Department;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void whenDepartmentExistsThenShouldBeReturned(){
        String name = "Tech";
        Department departmentMock = Department.builder()
                .departmentId(1L)
                .location("BLR")
                .name("Tech")
                .build();

        when(departmentRepository.findDepartmentByNameIgnoreCase("Tech")).thenReturn(Optional.ofNullable(departmentMock));
        assert departmentMock != null;
        assertEquals(name,departmentMock.getName());

    }
    @Test
    void whenDepartmentDoesNotExists_ThenShouldException(){
        String name = "Tech";
        Department departmentMock = null;

        when(departmentRepository.findDepartmentByNameIgnoreCase("Tech")).thenReturn(Optional.ofNullable(departmentMock));
        assertThrows(DepartmentNotFoundException.class,()->departmentService.getDepartmentByName(name));


    }

}