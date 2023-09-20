package com.example.shopping.controller;

import com.example.shopping.dto.ReportsDto;
import com.example.shopping.dto.request.ReportsRequest;
import com.example.shopping.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
@RequiredArgsConstructor
public class ReportsController {
    final ReportsService reportsService;

    @GetMapping(value = "/reportsList")
    public List<ReportsDto> getReportsInfo(){
        return reportsService.getAll();
    }

    @GetMapping(value = "getReportsById/{id}")
    public ReportsDto getReportsById(@PathVariable(value = "id")Long id){
        return reportsService.getReportsById(id);
    }
    @PostMapping(value = "/saveReports")
    public void saveReports(@RequestBody ReportsRequest reportsRequest){
        reportsService.saveReports(reportsRequest);
    }
    @PostMapping(value = "/updateReports")
    public void updateReports(@RequestBody ReportsRequest reportsRequest){
        reportsService.updateReports(reportsRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        reportsService.deleteById(id);
    }


}
