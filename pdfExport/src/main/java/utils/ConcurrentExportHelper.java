package utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

public final class ConcurrentExportHelper {


    private static ConcurrentExportHelper helper = new ConcurrentExportHelper();

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    private ConcurrentExportHelper() {

    }

    public static ConcurrentExportHelper getInstance() {
        return helper;
    }

    public void startConcurrentScore(String outputPath, String inputPath, String pic, List<Map<String, String>> excelList) {


        int threadSum = this.getThreadSum();

        // 计算每个线程的试卷数
        int capacity = excelList.size() / threadSum;

        int k = 0;
        List<Map<String, String>> sub = new ArrayList<Map<String, String>>();
        for (Map<String, String> m : excelList) {
            sub.add(m);
            k++;

            if (k >= capacity) {
                startThread(outputPath, inputPath, pic, sub);
                sub = new ArrayList<Map<String, String>>();
                k = 0;
            }

        }

        if (!sub.isEmpty())
            startThread(outputPath, inputPath, pic, excelList);

    }

    /**
     * 获取线程总数
     *
     * @return
     */
    public int getThreadSum() {
        return 100;
    }


    public void startThread(String outputPath, String inputPath, String pic, List<Map<String, String>> excelList) {

        new Thread() {

            @Override
            public void run() {
                for (Map<String, String> student : excelList) {


                    String name = student.get("name");

                    String folderName = student.get("folderName");

                    Map imgInfo = new HashMap();

                    imgInfo.put("id", pic);

                    imgInfo.put("outputFilePath", "H:\\" + sdf.format(new Date()) +"\\" + folderName + "\\");
                    imgInfo.put("fileName", name + ".jpg");
                    imgInfo.put("imgurl", "H:\\" + pic);


                    ChartGraphics.graphicsGeneration(student, imgInfo);


                    System.out.println("学生姓名 : " + name);
                }
            }
        }.start();
    }


}
