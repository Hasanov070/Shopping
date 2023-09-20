package com.example.shopping.service.impl;

import com.example.shopping.dto.EmployeesDto;
import com.example.shopping.dto.request.EmployeesRequest;
import com.example.shopping.model.Employees;
import com.example.shopping.repository.EmployeesRepository;
import com.example.shopping.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeesServiceImpl implements EmployeesService {
    final EmployeesRepository employeesRepository;
    @Override
    public EmployeesDto getEmployeesById(Long id) {
        Employees employees = employeesRepository.getEmployeesById(id);

        return EmployeesDto.builder()
                .firstName(employees.getFirstName())
                .lastName(employees.getLastName())
                .userName(employees.getUserName())
                .build();
    }

    @Override
    public void saveEmployees(EmployeesRequest employeesRequest) {
        Employees employees = Employees.builder()
                .userName(employeesRequest.getUserName())
                .firstName(employeesRequest.getFirstName())
                .lastName(employeesRequest.getLastName())
                .build();

        employeesRepository.save(employees);

    }

    @Override
    public void updateEmployees(EmployeesRequest employeesRequest) {
        Employees employees = Employees.builder()
                .id(employeesRequest.getId())
                .firstName(employeesRequest.getFirstName())
                .lastName(employeesRequest.getLastName())
                .address(employeesRequest.getAddress())
                .contactADD(employeesRequest.getContactADD())
                .passWord(employeesRequest.getPassWord())
                .build();

        employeesRepository.save(employees);

    }

    @Override
    public List<EmployeesDto> getAll() {
        List<Employees> employees = employeesRepository.findAll();
        List<EmployeesDto> employeesDtos = new ArrayList<>();
        for(Employees employees1 : employees)
        {
            EmployeesDto employeesDto = EmployeesDto.builder()
                    .firstName(employees1.getFirstName())
                    .lastName(employees1.getLastName())
                    .userName(employees1.getUserName())
                    .build();
        }
        return employeesDtos;
    }

    @Override
    public void deleteById(Long id) {
        Employees employees = employeesRepository.getEmployeesById(id);
        if(employees.getId().equals(null))
        {
            throw new RuntimeException("There is no such information");
        }
        else
        {
            employeesRepository.deleteById(id);
        }

    }
}
