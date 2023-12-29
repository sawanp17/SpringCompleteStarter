package com.example.demo.Controller;

import com.example.demo.Entities.Department;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@WebMvcTest(DepartmentController.class)
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

        mockMvc.perform(MockMvcRequestBuilders.post("/add").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"Tech\",\n" +
                        "    \"location\": \"BLR\"\n" +
                        "}")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {
        Department inputDepartment = Department.builder()
                .name("Tech")
                .location("BLR")
                .build();
        Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(mockDepartment);
        mockMvc.perform(MockMvcRequestBuilders.get("/getById/1")
//                .contentType(MediaType.APPLICATION_JSON))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(mockDepartment));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(mockDepartment.getName()));
    }

}