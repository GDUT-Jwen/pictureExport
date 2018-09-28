package com.springmvc.ctrl;


import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import utils.ExcelUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UploadExcelCtrl {

    /**
     * 上传文件
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/uploadFile")
        public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException, BiffException {
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = mRequest.getFile("file");
        Workbook workbook = Workbook.getWorkbook(file.getInputStream());
        ExcelUtils.readTemplate(workbook);
        return "success";
    }
}
