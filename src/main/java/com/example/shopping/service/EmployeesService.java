package com.example.shopping.service;

import com.example.shopping.dto.EmployeesDto;
import com.example.shopping.dto.request.EmployeesRequest;

import java.util.List;

public interface EmployeesService {
    EmployeesDto getEmployeesById(Long id);

    void saveEmployees(EmployeesRequest employeesRequest);

    void updateEmployees(EmployeesRequest employeesRequest);

    List<EmployeesDto> getAll();

    void deleteById(Long id);
}
