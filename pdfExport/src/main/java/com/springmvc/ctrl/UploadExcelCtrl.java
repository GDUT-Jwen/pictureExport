package com.springmvc.ctrl;


import com.springmvc.service.ExcelHandleService;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class UploadExcelCtrl {

    @Autowired
    private ExcelHandleService excelHandleService;


    /**
     * 上传文件
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
        public String response (HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException, BiffException {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = mRequest.getFile("file");
        String pic = mRequest.getParameter("pic");
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        List<Map<String,String>> resultList = new ArrayList<>();
        //遍历Sheet页
        Sheet sheet = workbook.getSheet(0);
        int size = sheet.getRows();
        for (int i = 1; i < size; i++) {
            List innerList = new ArrayList();
            Map<String, String> studentInfo = new HashMap<>();
            // sheet.getColumns()返回该页的总列数
            for (int j = 0; j < sheet.getColumns(); j++) {
                String cellinfo = sheet.getCell(j, i).getContents();
                cellinfo = cellinfo.replaceAll("\\s*", "");
                switch (j) {
                    case 0:
                        studentInfo.put("level", cellinfo);break;
                    case 1:
                        studentInfo.put("name", cellinfo);break;
                    case 2:
                        studentInfo.put("score", cellinfo);break;
                    case 3:
                        studentInfo.put("studyHour", cellinfo);break;
                    case 4:
                        studentInfo.put("runningDay", cellinfo);break;
                }
            }
            resultList.add(studentInfo);
        }

        excelHandleService.handleExcel(pic,resultList);

        System.out.println("总人数 : " + resultList.size());

        return "success";

    }
}
