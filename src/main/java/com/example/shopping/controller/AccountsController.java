package com.example.shopping.controller;

import com.example.shopping.dto.AccountsDto;
import com.example.shopping.dto.request.AccountsRequest;
import com.example.shopping.model.Accounts;
import com.example.shopping.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
@RequiredArgsConstructor
public class AccountsController {
    final AccountsService accountsService;

    @GetMapping(value = "/accountList")
    public List<AccountsDto> getAccountsInto(){
        return accountsService.getAll();
    }

    @GetMapping(value = "/getAccountsById/{id}")
    public AccountsDto getAccountsById(@PathVariable(value = "id") Long id){
        return accountsService.getAccountsById(id);
    }
    @PostMapping(value = "/saveAccounts")
    public void saveAccounts(@RequestBody AccountsRequest accountsRequest)
    {
        accountsService.saveAccounts(accountsRequest);
    }
    @PostMapping(value = "/updateAccounts")
    public void updateAccounts(@RequestBody AccountsRequest accountsRequest)
    {
        accountsService.updateAccounts(accountsRequest);
    }
    @DeleteMapping(value = "/deleteByAccId/{id}")
    public void deleteByAccId(@PathVariable(value = "id")Long id)
    {
        accountsService.deleteById(id);
    }



}
