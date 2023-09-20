package com.example.shopping.service.impl;

import com.example.shopping.dto.TransactionsDto;
import com.example.shopping.dto.request.TransactionsRequest;
import com.example.shopping.model.Transactions;
import com.example.shopping.repository.TransactionsRepository;
import com.example.shopping.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionsServiceImpl implements TransactionsService {

    private final TransactionsRepository transactionsRepository;

    @Override
    public TransactionsDto getTransactionsById(Long id) {
        Transactions transactions = transactionsRepository.getTransactionsById(id);

        return TransactionsDto.builder()
                .name(transactions.getName())
                .build();
    }

    @Override
    public void saveTransactions(TransactionsRequest transactionsRequest) {

        Transactions transactions = Transactions.builder()
                .name(transactionsRequest.getName())
                .build();
        transactionsRepository.save(transactions);

    }

    @Override
    public void updateTransactions(TransactionsRequest transactionsRequest) {
        Transactions transactions = Transactions.builder()
                .id(transactionsRequest.getId())
                .name(transactionsRequest.getName())
                .build();
        transactionsRepository.save(transactions);

    }

    @Override
    public List<TransactionsDto> getAll() {
        List<Transactions> transactions = transactionsRepository.findAll();
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        for (Transactions transactions1 : transactions)
        {
            TransactionsDto transactionsDto = TransactionsDto.builder()
                    .name(transactions1.getName())
                    .build();
        }

        return transactionsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Transactions transactions = transactionsRepository.getTransactionsById(id);
        if (transactions.getId().equals(null))
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            transactionsRepository.deleteById(id);
        }

    }
}
