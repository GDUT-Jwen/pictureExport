package com.springmvc.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("excelHandleService")
public class ExcelHandleServiceImpl implements ExcelHandleService{

    public void handleExcel(List<Map<String,String>> excelList) {

        System.out.println("excelHandleService");

        for(Map<String,String> student : excelList) {
            System.out.println("学生姓名 : " + student.get("name"));
        }

    }
}
