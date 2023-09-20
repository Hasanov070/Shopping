package com.example.shopping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String contactADD;
    private String userName;
    private String passWord;

}
