package com.example.shopping.service.impl;

import com.example.shopping.dto.ReportsDto;
import com.example.shopping.dto.request.ReportsRequest;
import com.example.shopping.model.Reports;
import com.example.shopping.repository.ReportsRepository;
import com.example.shopping.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReportsServiceImpl implements ReportsService {
    final ReportsRepository reportsRepository;
    @Override
    public ReportsDto getReportsById(Long id) {
        Reports reports = reportsRepository.getReportsById(id);

        return ReportsDto.builder()
                .reportDate(reports.getReportDate())
                .reportName(reports.getReportName())
                .build();
    }

    @Override
    public void saveReports(ReportsRequest reportsRequest) {
        Reports reports = Reports.builder()
                .reportDate(reportsRequest.getReportDate())
                .reportName(reportsRequest.getReportName())
                .build();
        reportsRepository.save(reports);

    }

    @Override
    public void updateReports(ReportsRequest reportsRequest) {

        Reports reports = Reports.builder()
                .id(reportsRequest.getId())
                .reportName(reportsRequest.getReportName())
                .reportDate(reportsRequest.getReportName())
                .build();

        reportsRepository.save(reports);

    }

    @Override
    public List<ReportsDto> getAll() {
        List<Reports> reports = reportsRepository.findAll();
        List<ReportsDto> reportsDtos = new ArrayList<>();

        for (Reports reports1 : reports)
        {
            ReportsDto reportsDto = ReportsDto.builder()
                    .reportName(reports1.getReportName())
                    .reportDate(reports1.getReportDate())
                    .build();
        }
        return reportsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Reports reports = reportsRepository.getReportsById(id);
        if (reports.getId().equals(null))
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            reportsRepository.deleteById(id);
        }

    }
}
