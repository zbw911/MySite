package com.zhangbaowei.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
@RequestMapping("/")
public class HomeController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }


    @RequestMapping({"/", "/index"})
    public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String host = null;

        try {
            URL   url = new URL(request.getRequestURL().toString());
              host  = url.getHost();
            System.out.println(host);

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

        if(host != null && host.toLowerCase().indexOf("zhuangniyukonglong.com")>=0)
        {
            return "zhuangniyukonglong/index";
        }


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
