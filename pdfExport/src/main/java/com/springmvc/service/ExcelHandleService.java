package com.springmvc.service;

import java.util.List;
import java.util.Map;

public interface ExcelHandleService {

    void handleExcel(String pic,List<Map<String,String>> excelList);

}

