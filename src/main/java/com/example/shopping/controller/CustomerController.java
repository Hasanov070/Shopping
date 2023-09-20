package com.example.shopping.controller;

import com.example.shopping.dto.CustomerDto;
import com.example.shopping.dto.request.CustomerRequest;
import com.example.shopping.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService customerService;

    @GetMapping(value = "/customerList")
    public List<CustomerDto> getCustomerInfo(){
        return customerService.getAll();
    }
    @GetMapping(value = "/getCustomerById/{id}")
    public CustomerDto getCustomerById(@PathVariable(value = "id")Long id){
        return customerService.getAllCustomerById(id);
    }
    @PostMapping(value = "/saveCustomer")
    public void saveCustomer(@RequestBody CustomerRequest customerRequest)
    {
        customerService.saveCustomer(customerRequest);
    }
    @PostMapping(value = "updateCustomer")
    public void updateCustomer(@RequestBody CustomerRequest customerRequest)
    {
        customerService.updateCustomer(customerRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        customerService.deleteById(id);
    }






}
