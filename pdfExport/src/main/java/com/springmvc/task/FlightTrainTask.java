package com.springmvc.task;

import com.springmvc.ctrl.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class FlightTrainTask {

    @Autowired
    private Customer customer;

    @Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    public void taskCycle() throws IOException, TimeoutException {
//        System.out.println("使用SpringMVC框架配置定时任务");
        customer.getMessage();
    }
}