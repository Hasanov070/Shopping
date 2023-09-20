package com.example.shopping.service.impl;

import com.example.shopping.dto.LogsDto;
import com.example.shopping.dto.request.LogsRequest;
import com.example.shopping.model.Logs;
import com.example.shopping.repository.LogsRepository;
import com.example.shopping.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LogsServiceImpl implements LogsService {

    final LogsRepository logsRepository;

    @Override
    public LogsDto getLogsById(Long id) {
        Logs logs = logsRepository.getLogsById(id);
        return LogsDto.builder()
                .loginDate(logs.getLoginDate())
                .loginTime(logs.getLoginTime())
                .build();
    }

    @Override
    public void saveLogs(LogsRequest logsRequest) {
        Logs logs = Logs.builder()
                .loginDate(logsRequest.getLoginDate())
                .loginTime(logsRequest.getLoginTime())
                .build();
        logsRepository.save(logs);

    }

    @Override
    public void updateLogs(LogsRequest logsRequest) {
        Logs logs = Logs.builder()
                .id(logsRequest.getId())
                .loginTime(logsRequest.getLoginTime())
                .loginDate(logsRequest.getLoginDate())
                .build();
        logsRepository.save(logs);

    }


    @Override
    public List<LogsDto> getAll() {
        List<Logs> logs = logsRepository.findAll();
        List<LogsDto> logsDtos = new ArrayList<>();
        for (Logs logs1 : logs)
        {
            LogsDto logsDto = LogsDto.builder()
                    .loginTime(logs1.getLoginTime())
                    .loginDate(logs1.getLoginDate())
                    .build();
        }
        return logsDtos;
    }

    @Override
    public void deleteById(Long id) {
        Logs logs = logsRepository.getLogsById(id);
        if(logs.getId().equals(null))
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            logsRepository.deleteById(id);
        }
    }

    }
