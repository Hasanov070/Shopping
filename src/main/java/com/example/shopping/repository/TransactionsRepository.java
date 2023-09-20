package com.example.shopping.repository;

import com.example.shopping.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
    Transactions getTransactionsById(Long id);
}
