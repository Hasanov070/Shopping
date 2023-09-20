package com.example.shopping.controller;

import com.example.shopping.dto.EmployeesDto;
import com.example.shopping.dto.request.EmployeesRequest;
import com.example.shopping.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
public class EmployeesController {
    final EmployeesService employeesService;

    @GetMapping(value = "/employeesList")
    public List<EmployeesDto> getEmployeesInfo()
    {
        return employeesService.getAll();
    }
    @GetMapping(value = "/getEmployeesById/{id}")
    public EmployeesDto getEmployeesById(@PathVariable(value = "id")Long id){
        return employeesService.getEmployeesById(id);
    }
    @PostMapping(value = "/saveEmployees")
    public void saveEmployees(@RequestBody EmployeesRequest employeesRequest){
        employeesService.saveEmployees(employeesRequest);
    }
    @PostMapping(value = "/updateEmployees")
    public void updateEmployees(@RequestBody EmployeesRequest employeesRequest){
        employeesService.updateEmployees(employeesRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        employeesService.deleteById(id);
    }


}
