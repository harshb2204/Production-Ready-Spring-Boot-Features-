package com.example.production_ready_features.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeDTO {

    private Long id;

    private String name;
    private Integer age;


    private String role;
    private LocalDate joiningdata;
    private boolean isActive;


}
