package com.example.jasperreports.rest;

import com.example.jasperreports.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/export-sql")
    public String getResponse() throws IOException {
        return reportService.exportSql();
    }
}

