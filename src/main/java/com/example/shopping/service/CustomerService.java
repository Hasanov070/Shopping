package com.example.shopping.service;

import com.example.shopping.dto.CustomerDto;
import com.example.shopping.dto.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    CustomerDto getAllCustomerById(Long id);

    void saveCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest);

    List<CustomerDto> getAll();

    void deleteById(Long id);
}
