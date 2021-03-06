package com.zhangbaowei.demo.controllers;

import com.zhangbaowei.demo.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class ArtController {
    @RequestMapping({"/", "/index"})
    public String index(Model model) {
//        model.addAttribute("username", username);


        TestModel tm = new TestModel() {{
            setSex("男");
            setUserId(1);
            setUserName("zbw");
            setDiscript("用于测试的<b>加黑</b>的");
        }};

        model.addAttribute("tm", tm);

        return "article/index";
    }


    @RequestMapping({"/v"})
    public String video(Model model) {
//        model.addAttribute("username", username);


        return "article/video";
    }
}
