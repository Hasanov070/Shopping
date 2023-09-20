package com.example.shopping.repository;

import com.example.shopping.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReportsRepository extends JpaRepository<Reports,Long> {
    Reports getReportsById(Long id);
}
