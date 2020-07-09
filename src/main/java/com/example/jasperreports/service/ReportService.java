package com.example.jasperreports.service;

import com.example.jasperreports.utils.SimpleReportExporter;
import com.example.jasperreports.utils.SimpleReportFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReportService {

    @Autowired
    private SimpleReportFiller simpleReportFiller;

    @Autowired
    private SimpleReportExporter simpleExporter;

    public String exportSql() throws IOException {
        simpleReportFiller.setReportFileName("employeeEmailReport.jrxml");
        simpleReportFiller.compileReport();

        simpleReportFiller.setReportFileName("employeeReport.jrxml");
        simpleReportFiller.compileReport();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", "Employee Report Example");
        parameters.put("minSalary", 15000.0);
        parameters.put("condition", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        BufferedImage image = ImageIO.read(getClass().getClassLoader().getResource("img.png"));
        parameters.put("logo", image );

        simpleReportFiller.setParameters(parameters);
        simpleReportFiller.fillReport();

        simpleExporter.setJasperPrint(simpleReportFiller.getJasperPrint());

        simpleExporter.exportToPdf("employeeReport.pdf", "baeldung");
        simpleExporter.exportToXlsx("employeeReport.xlsx", "Employee Data");
        simpleExporter.exportToCsv("employeeReport.csv");
        simpleExporter.exportToHtml("employeeReport.html");
        return "Ok";
    }
}
