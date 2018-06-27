package com.zhangbaowei.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/chart")
public class ChartController {


    @RequestMapping("/")
    public String Index() {
        return "chart/index";
    }


    @ResponseBody
    @RequestMapping("/data")
    public List<Datas> ChartData(double from, double to) {
        List<Datas> list = new ArrayList<>();

        if (from == 0)
            from = System.currentTimeMillis() - 100L * 24 * 3600 * 1000;

        if (to == 0)
            to = System.currentTimeMillis() + 100L * 24 * 3600 * 1000;



        double timestamp = to - from;


        double step = timestamp / 100;


        double temp = from;
        Random random = new Random();
        do {
            Datas d = new Datas();
            d.setTime(temp);
            d.setData(random.nextInt(100));

            list.add(d);

            if (temp > to)
                break;

            temp = temp + (step);

        } while (true);

        return list;
    }

    public class Datas {
        private double time;
        private int data;

        public double getTime() {
            return time;
        }

        public void setTime(double time) {
            this.time = time;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

}




