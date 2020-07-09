package com.example.jasperreports.rest;

import com.example.jasperreports.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/run")
    public String getResponse() {
        return reportService.run();
    }
}

