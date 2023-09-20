package com.example.shopping.service;

import com.example.shopping.dto.LogsDto;
import com.example.shopping.dto.request.LogsRequest;

import java.util.List;

public interface LogsService {
    LogsDto getLogsById(Long id);

    void saveLogs(LogsRequest logsRequest);
    void updateLogs(LogsRequest logsRequest);

    List<LogsDto> getAll();

    void deleteById(Long id);

}
