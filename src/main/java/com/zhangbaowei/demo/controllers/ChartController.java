package com.zhangbaowei.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/chart")
public class ChartController {


    ChartController() {

    }

    @RequestMapping("/")
    public String Index() {
        return "chart/index";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<Datas> ChartData(double from, double to) throws ParseException, InterruptedException {


        if (from == 0) {

            //注意format的格式要与日期String的格式相匹配
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss").parseDateTime("04/02/2011 20:27:05");
            Date date = sdf.parse("2018/01/10 0:0:0");
            if (from == 0)
                from = date.getTime();

            if (to == 0)
                to = date.getTime() + 1L * 24 * 3600 * 1000;

            MockData.initData(from, to);
        }


//        Thread.sleep(3 * 1000);
        List<Datas> list = new ArrayList<>();
        double timestamp = to - from;
        double step = timestamp / 10;


        if (to - from > 15 * 24 * 3600 * 1000) {
            step = 24 * 3600 * 1000; //天
        } else if (to - from >= 24 * 3600 * 1000) {
            step = 1 * 3600 * 1000; //小时
        } else if (to - from >= 1 * 3600 * 1000) {
            step = 60 * 1000; //分
        } else if (to - from <= 1000) {
            to = from + 1000;
            step = 1000;
        }
        if (step < 1000)
            step = 1000;

        from = ((int) (from / step) * step);

        if (from == 0) {
            return list;
        }

        double temp = from;

        do {
            Datas d = new Datas();
            d.setTime(temp);
            int sumdata = MockData.getdata(temp, temp + step);
            d.setData(sumdata);

            list.add(d);

            if (temp >= to)
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




