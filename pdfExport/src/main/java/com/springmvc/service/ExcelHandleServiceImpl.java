package com.springmvc.service;

import org.springframework.stereotype.Service;
import utils.ConcurrentExportHelper;

import java.util.List;
import java.util.Map;

@Service("excelHandleService")
public class ExcelHandleServiceImpl implements ExcelHandleService{

//    @Value("#{prop.outputPath}")
//    private String outputPath;
//
//    @Value("#{prop.inputPath}")
//    private String inputPath;

    public void handleExcel(String pic,List<Map<String,String>> excelList) {

        ConcurrentExportHelper.getInstance().startThread("","",pic,excelList);

    }
}
