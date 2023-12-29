package com.example.demo.Controller;

import com.example.demo.Entities.Department;
import com.example.demo.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@WebMvcTest
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department mockDepartment;
    @BeforeEach
    void setUp() {
        mockDepartment = Department.builder()
                .departmentId(1L)
                .name("Tech")
                .location("BLR")
                .build();
    }

    @Test
    void addDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .name("Tech")
                .location("BLR")
                .build();
        Mockito.when(departmentService.addDepartment(inputDepartment)).thenReturn(mockDepartment);

        mockMvc.perform(MockMvcRequestBuilders.post("").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"Tech\",\n" +
                        "    \"location\": \"BLR\"\n" +
                        "}")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}