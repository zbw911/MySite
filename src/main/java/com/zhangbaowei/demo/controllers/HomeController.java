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


    @RequestMapping({"/", "/index"})
    public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        return "home/index";
    }

    @RequestMapping("/post")
    public String Post(@RequestParam(value = "id", required = false, defaultValue = "0") String id, Model model) {

        return "home/post";
    }

    @RequestMapping("/about")
    public String About() {
        return "home/about";
    }

    @RequestMapping("/contact")
    public String Contact() {
        return "home/contact";
    }
}
