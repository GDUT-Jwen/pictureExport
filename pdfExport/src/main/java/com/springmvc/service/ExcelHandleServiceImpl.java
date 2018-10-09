package com.springmvc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import utils.ChartGraphics;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("excelHandleService")
public class ExcelHandleServiceImpl implements ExcelHandleService{

    @Value("#{prop.outputPath}")
    private String outputPath;

    @Value("#{prop.inputPath}")
    private String inputPath;

    public void handleExcel(String pic,List<Map<String,String>> excelList) {

        System.out.println("excelHandleService");

        for(Map<String,String> student : excelList) {


            String name = student.get("name");

            Map imgInfo = new HashMap();

            imgInfo.put("id",pic);

            imgInfo.put("outputFilePath",outputPath);
            imgInfo.put("fileName", name + ".jpg");
            imgInfo.put("imgurl",inputPath + pic);


            ChartGraphics.graphicsGeneration(student,imgInfo);


            System.out.println("学生姓名 : " + name);
        }

    }
}
