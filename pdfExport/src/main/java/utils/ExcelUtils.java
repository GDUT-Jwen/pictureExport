package utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    public static void readTemplate(Workbook workbook) throws IOException, WriteException {
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
                                            studentInfo.put("exp", cellinfo);break;
                                    case 3:
                                            studentInfo.put("studyTime", cellinfo);break;
                                    case 4:
                                            studentInfo.put("days", cellinfo);break;
                            }
                            System.out.print(cellinfo);
                    }
                    resultList.add(studentInfo);
                    System.out.println();
            }

            System.out.println("总人数 : " + resultList.size());
    }
}