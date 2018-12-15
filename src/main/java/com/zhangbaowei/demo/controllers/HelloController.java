package com.zhangbaowei.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String greet() throws InterruptedException {


        Thread.sleep(4 * 1000);

        return "";
    }

}