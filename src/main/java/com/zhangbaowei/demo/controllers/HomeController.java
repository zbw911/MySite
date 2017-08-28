package com.zhangbaowei.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }


    @RequestMapping("/")
    public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        return "index";
    }
}
