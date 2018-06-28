package com.zhangbaowei.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MockData {
    static Map<Double, Integer> dataStore = new HashMap<>();

    public static void initData(double from, double to) {
        Random random = new Random();
        //假设每秒记录一条数据
        for (double i = from; i < to; i = i + 60 * 1000) {
            dataStore.put(i, random.nextInt(100));
        }
    }


    public static void PrintData() {
        dataStore.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    public static int getdata(double from, double to) {
        return dataStore.keySet().stream().filter(x -> x >= from && x < to).map(x -> dataStore.get(x)).mapToInt(i -> i.intValue()).sum();
    }
}
