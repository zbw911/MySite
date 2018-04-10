package com.zhangbaowei.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ashxController {

    @RequestMapping({"/a.ashx", "/a"})
    @ResponseBody
    public String put() {

        return "a.ashx";
    }

    @RequestMapping({"/hehe"})
    @ResponseBody
    public String hehe(@RequestParam(required = true) String a) {
        return a;
    }

}
