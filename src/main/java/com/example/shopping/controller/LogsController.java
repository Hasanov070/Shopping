package com.example.shopping.controller;

import com.example.shopping.dto.LogsDto;
import com.example.shopping.dto.request.LogsRequest;
import com.example.shopping.model.Logs;
import com.example.shopping.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/logs")
@RequiredArgsConstructor
public class LogsController {
    final LogsService logsService;

    @GetMapping(value = "/logsList")
    public List<LogsDto> getLogsInfo(){
        return logsService.getAll();
    }
    @GetMapping(value = "/getLogsById/{id}")
    public LogsDto getLogsById(@PathVariable(value = "id")Long id){
        return logsService.getLogsById(id);
    }
    @PostMapping(value = "/saveLogs")
    public void saveLogs(@RequestBody LogsRequest logsRequest){
        logsService.saveLogs(logsRequest);
    }
    @PostMapping(value = "/updateLogs")
    public void updateLogs(@RequestBody LogsRequest logsRequest){
        logsService.updateLogs(logsRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        logsService.deleteById(id);
    }

}
