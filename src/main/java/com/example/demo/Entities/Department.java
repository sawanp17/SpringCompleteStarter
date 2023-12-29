package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotEmpty(message = "Please enter a name")
    private String name;

    private String location;

    public Department(){

    }
    public Department(final Long departmentId, final String name, final String location) {
        this.departmentId = departmentId;
        this.name = name;
        this.location = location;
    }

}
