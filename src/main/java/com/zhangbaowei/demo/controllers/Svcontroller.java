package com.zhangbaowei.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/aaa.svc")
public class Svcontroller {

    @RequestMapping("/put")
    @ResponseBody
    public String put() {

        return "PUT OK";
    }



}
