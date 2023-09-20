package com.example.shopping.service;

import com.example.shopping.dto.TransactionsDto;
import com.example.shopping.dto.request.TransactionsRequest;

import java.util.List;

public interface TransactionsService {
    TransactionsDto getTransactionsById(Long id);

    void saveTransactions(TransactionsRequest transactionsRequest);

    void updateTransactions(TransactionsRequest transactionsRequest);

    List<TransactionsDto> getAll();

    void deleteById(Long id);

}
