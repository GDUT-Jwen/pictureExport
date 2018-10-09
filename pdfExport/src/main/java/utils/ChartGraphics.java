package utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ChartGraphics {

    private static BufferedImage image;

    //姓名
    private static String name ;
    //名次
    private static String level ;
    //积分
    private static String score ;
    //时长
    private static String studyHour ;
    //上线天数
    private static String runningDay ;



    //生成图片文件
    private static void createImage(String filePath, String fileName) {
        BufferedOutputStream bos = null;
        if (image != null) {
            try {
                File folder = new File(filePath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                // 如果文件不存在就创建
                File file = new File(filePath + fileName);
                if (!file.exists()) {
                    System.out.println("文件不存在，创建文件:" + filePath + fileName);
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                FileOutputStream fos = new FileOutputStream(filePath + fileName);
                bos = new BufferedOutputStream(fos);

                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
                encoder.encode(image);
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bos != null) {//关闭输出流
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * @param map           输入信息
     * @param id
     * @param outputFileUrl 输出文件路径
     * @param imgurl        输入文件路径
     */
    public static void graphicsGeneration(Map<String, String> map, Map<String, String> imgInfo) {

        //姓名
        name = map.get("name");
        //名次
        level = map.get("level");
        //积分
        score = map.get("score");
        //时长
        studyHour = map.get("studyHour");
        //上线天数
        runningDay = map.get("runningDay");

        String id = imgInfo.get("id");

        String outputFilePath = imgInfo.get("outputFilePath");

        String fileName = imgInfo.get("fileName");

        String imgurl = imgInfo.get("imgurl");

        int imageWidth = 1200;  //图片的宽度
        int imageHeight = 1800; //图片的高度

        if ("1.jpg".equals(id)) {
            putStudentInfo(imgurl,imageWidth,imageHeight);
        }else if("2.jpg".equals((id))) {
            putStudentInfo2(imgurl,imageWidth,imageHeight);
        }else if("3.jpg".equals(id)) {
            putStudentInfo3(imgurl,imageWidth,imageHeight);
        }else if("4.jpg".equals(id)) {
            putStudentInfo4(imgurl,imageWidth,imageHeight);
        }else if("5.jpg".equals(id)) {
            putStudentInfo5(imgurl,imageWidth,imageHeight);
        }

        createImage(outputFilePath, fileName);

    }


    private static void putStudentInfo(String imgurl, int imageWidth, int imageHeight) {

        int H_title = 30;    //头部高度
        int H_mainPic = 1800;  //轮播广告高度
        int H_tip = 60;  //上网提示框高度
        int tip_2_top = (600);
        int bottomFont = tip_2_top + 150;

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);


        //***********************插入中间广告图
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {
        }

        if (bimg != null) {
            mainPic.drawImage(bimg, 0, H_title, imageWidth, H_mainPic, null);
            mainPic.dispose();
        }
        //***********************设置下面的提示框

        Graphics2D tip = image.createGraphics();

        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.BLACK);
        //设置字体
        Font tipFont = new Font("微软雅黑", Font.BOLD, 80);
        tip.setFont(tipFont);

        tip.drawString(name, imageWidth / 2 - 180, tip_2_top + (H_tip) / 2);
        tip.drawString(level, imageWidth / 2 + 70, tip_2_top + (H_tip) / 2 + 160);
        tip.drawString(score, imageWidth / 2 + 120, tip_2_top + (H_tip) / 2 + 300);
        tip.drawString(studyHour, imageWidth / 2 + 120, tip_2_top + (H_tip) / 2 + 450);
        tip.drawString(runningDay, imageWidth / 2 + 120, tip_2_top + (H_tip) / 2 + 600);

        //***********************按钮
        Font btnFont = new Font("微软雅黑", Font.BOLD, 50);
        Graphics2D btn1 = image.createGraphics();
        //btn1 文本
        btn1.setColor(Color.red);
        btn1.setFont(btnFont);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateTime = sdf.format(new Date());
        btn1.drawString(dateTime, imageWidth - 450, bottomFont + 850);

    }

    private static void putStudentInfo2(String imgurl, int imageWidth, int imageHeight) {

        int H_title = 30;    //头部高度
        int H_mainPic = 1800;  //轮播广告高度
        int H_tip = 60;  //上网提示框高度
        int tip_2_top = (320);
        int bottomFont = tip_2_top + 150;

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);


        //***********************插入中间广告图
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {
        }

        if (bimg != null) {
            mainPic.drawImage(bimg, 0, H_title, imageWidth, H_mainPic, null);
            mainPic.dispose();
        }
        //***********************设置下面的提示框

        Graphics2D tip = image.createGraphics();

        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.BLACK);
        //设置字体
        Font tipFont = new Font("微软雅黑", Font.BOLD, 80);
        tip.setFont(tipFont);

        tip.drawString(name, imageWidth / 2 - 350, tip_2_top + (H_tip) / 2);
        tip.drawString(level, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 260);
        tip.drawString(score, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 420);
        tip.drawString(studyHour, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 580);
        tip.drawString(runningDay, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 750);

        //***********************按钮
        Font btnFont = new Font("微软雅黑", Font.BOLD, 50);
        Graphics2D btn1 = image.createGraphics();
        //btn1 文本
        btn1.setColor(Color.red);
        btn1.setFont(btnFont);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateTime = sdf.format(new Date());
        btn1.drawString(dateTime, imageWidth - 490, bottomFont + 900);

    }


    private static void putStudentInfo3(String imgurl, int imageWidth, int imageHeight) {

        int H_title = 30;    //头部高度
        int H_mainPic = 1800;  //轮播广告高度
        int H_tip = 60;  //上网提示框高度
        int tip_2_top = (420);
        int bottomFont = tip_2_top + 150;

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);


        //***********************插入中间广告图
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {
        }

        if (bimg != null) {
            mainPic.drawImage(bimg, 0, H_title, imageWidth, H_mainPic, null);
            mainPic.dispose();
        }
        //***********************设置下面的提示框

        Graphics2D tip = image.createGraphics();

        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.BLACK);
        //设置字体
        Font tipFont = new Font("微软雅黑", Font.BOLD, 80);
        tip.setFont(tipFont);

        tip.drawString(name, imageWidth / 2 - 280, tip_2_top + (H_tip) / 2 + 100);
        tip.drawString(level, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 280);
        tip.drawString(score, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 420);
        tip.drawString(studyHour, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 580);
        tip.drawString(runningDay, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 750);

        //***********************按钮
        Font btnFont = new Font("微软雅黑", Font.BOLD, 50);
        Graphics2D btn1 = image.createGraphics();
        //btn1 文本
        btn1.setColor(Color.red);
        btn1.setFont(btnFont);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateTime = sdf.format(new Date());
        btn1.drawString(dateTime, imageWidth - 600, bottomFont + 900);

    }

    private static void putStudentInfo4(String imgurl, int imageWidth, int imageHeight) {

        int H_title = 30;    //头部高度
        int H_mainPic = 1800;  //轮播广告高度
        int H_tip = 60;  //上网提示框高度
        int tip_2_top = (220);
        int bottomFont = tip_2_top + 150;

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);


        //***********************插入中间广告图
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {
        }

        if (bimg != null) {
            mainPic.drawImage(bimg, 0, H_title, imageWidth, H_mainPic, null);
            mainPic.dispose();
        }
        //***********************设置下面的提示框

        Graphics2D tip = image.createGraphics();

        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.BLACK);
        //设置字体
        Font tipFont = new Font("微软雅黑", Font.BOLD, 80);
        tip.setFont(tipFont);

        tip.drawString(name, imageWidth / 2 - 130, tip_2_top + (H_tip) / 2);
        tip.drawString(level, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 360);
        tip.drawString(score, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 490);
        tip.drawString(studyHour, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 620);
        tip.drawString(runningDay, imageWidth / 2 + 200, tip_2_top + (H_tip) / 2 + 780);

        //***********************按钮
        Font btnFont = new Font("微软雅黑", Font.BOLD, 50);
        Graphics2D btn1 = image.createGraphics();
        //btn1 文本
        btn1.setColor(Color.red);
        btn1.setFont(btnFont);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateTime = sdf.format(new Date());
        btn1.drawString(dateTime, imageWidth - 600, bottomFont + 900);

    }


    private static void putStudentInfo5(String imgurl, int imageWidth, int imageHeight) {

        int H_title = 30;    //头部高度
        int H_mainPic = 1800;  //轮播广告高度
        int H_tip = 60;  //上网提示框高度
        int tip_2_top = (220);
        int bottomFont = tip_2_top + 150;

        image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        //设置图片的背景色
        Graphics2D main = image.createGraphics();
        main.setColor(Color.white);
        main.fillRect(0, 0, imageWidth, imageHeight);


        //***********************插入中间广告图
        Graphics mainPic = image.getGraphics();
        BufferedImage bimg = null;
        try {
            bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
        } catch (Exception e) {
        }

        if (bimg != null) {
            mainPic.drawImage(bimg, 0, H_title, imageWidth, H_mainPic, null);
            mainPic.dispose();
        }
        //***********************设置下面的提示框

        Graphics2D tip = image.createGraphics();

        //设置字体颜色，先设置颜色，再填充内容
        tip.setColor(Color.BLACK);
        //设置字体
        Font tipFont = new Font("微软雅黑", Font.BOLD, 80);
        tip.setFont(tipFont);

        tip.drawString(name, imageWidth / 2 - 130, tip_2_top + (H_tip) / 2);
        tip.drawString(level, imageWidth / 2 + 100, tip_2_top + (H_tip) / 2 + 360);
        tip.drawString(score, imageWidth / 2 + 100, tip_2_top + (H_tip) / 2 + 550);
        tip.drawString(studyHour, imageWidth / 2 + 100, tip_2_top + (H_tip) / 2 + 740);
        tip.drawString(runningDay, imageWidth / 2 + 100, tip_2_top + (H_tip) / 2 + 920);

        //***********************按钮
        Font btnFont = new Font("微软雅黑", Font.BOLD, 50);
        Graphics2D btn1 = image.createGraphics();
        //btn1 文本
        btn1.setColor(Color.red);
        btn1.setFont(btnFont);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateTime = sdf.format(new Date());
        btn1.drawString(dateTime, imageWidth - 600, bottomFont + 950);

    }


    public static void main(String[] args) {
        String[] fonts =
                GraphicsEnvironment  // GraphicsEnvironment(抽象类)  图形环境类
                        .getLocalGraphicsEnvironment()  // 获取本地图形环境
                        .getAvailableFontFamilyNames();  // 获取可用字体family名

        int fontCount = 0;   // 字体数统计
        for (String font : fonts) {
            fontCount++;
            System.out.println(font);
        }
        System.out.println("系统字体数:" + fontCount);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateTime = sdf.format(new Date());
        System.out.println("当前日期:" + dateTime);
    }


}