package com.example.shopping.controller;

import com.example.shopping.dto.TransactionsDto;
import com.example.shopping.dto.request.TransactionsRequest;
import com.example.shopping.model.Transactions;
import com.example.shopping.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
@RequiredArgsConstructor
public class TransactionsController {

    final TransactionsService transactionsService;

    @GetMapping(value = "/transactionsList")
    public List<TransactionsDto> getTransactionsInfo(){
        return transactionsService.getAll();
    }

    @GetMapping(value = "/getTransactionsById/{id}")
    public TransactionsDto getTransactionsById(@PathVariable(value = "id")Long id){
        return transactionsService.getTransactionsById(id);
    }
    @PostMapping(value = "/saveTransactions")
    public void saveTransactions(@RequestBody TransactionsRequest transactionsRequest){
        transactionsService.saveTransactions(transactionsRequest);
    }
    @PostMapping(value = "/updateTransactions")
    public void updateTransactions(@RequestBody TransactionsRequest transactionsRequest){
        transactionsService.updateTransactions(transactionsRequest);
    }
    @DeleteMapping(value = "/deleteById")
    public void deleteById(@PathVariable(value = "id")Long id){
        transactionsService.deleteById(id);
    }






}
