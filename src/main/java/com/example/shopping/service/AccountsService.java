package com.example.shopping.service;

import com.example.shopping.dto.AccountsDto;
import com.example.shopping.dto.request.AccountsRequest;

import java.util.List;

public interface AccountsService {
    AccountsDto getAccountsById(Long id);

    void saveAccounts(AccountsRequest accountsRequest);

    void updateAccounts(AccountsRequest accountsRequest);

    List<AccountsDto> getAll();

    void deleteById(Long id);
}
