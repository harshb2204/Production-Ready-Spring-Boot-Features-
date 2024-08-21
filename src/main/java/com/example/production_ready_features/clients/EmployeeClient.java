package com.example.production_ready_features.clients;

import com.example.production_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeebyid(Long employeeId);

    EmployeeDTO createnewemployee(EmployeeDTO employeeDTO);
}
