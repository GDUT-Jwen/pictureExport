package com.springmvc.ctrl;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Service;
import utils.ChartGraphics;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Service
public class Customer {
    private final static String QUEUE_NAME = "rabbitMQ.test";

    public void getMessage() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ地址
        factory.setHost("localhost");
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //声明要关注的队列
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
//        System.out.println("Customer Waiting Received messages");
        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");

                Map studentInfoMap = new HashMap();

                Map imgInfo = new HashMap();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                String outputPath = "H:\\" + sdf.format(new Date()) + "\\";

                imgInfo.put("id","5.jpg");

                imgInfo.put("outputFilePath",outputPath);
                imgInfo.put("fileName","output.jpg");
                imgInfo.put("imgurl","H:\\5.jpg");


                ChartGraphics.graphicsGeneration(studentInfoMap,imgInfo);
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}