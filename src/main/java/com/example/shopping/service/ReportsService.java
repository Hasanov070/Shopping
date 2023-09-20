package com.example.shopping.service;

import com.example.shopping.dto.ReportsDto;
import com.example.shopping.dto.request.ReportsRequest;

import java.util.List;

public interface ReportsService {
    ReportsDto getReportsById(Long id);

    void saveReports(ReportsRequest reportsRequest);

    void updateReports(ReportsRequest reportsRequest);

    List<ReportsDto> getAll();

    void deleteById(Long id);
}
