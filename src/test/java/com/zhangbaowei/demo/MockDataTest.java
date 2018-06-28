package com.zhangbaowei.demo;


import com.zhangbaowei.demo.controllers.MockData;
import org.junit.Test;

public class MockDataTest {
    @Test
    public void name() {

        MockData md = new MockData();

        MockData.initData(1 * 1000, 10 * 1000);

        MockData.PrintData();

        System.out.println(MockData.getdata(1 * 1000, 3 * 1000));
        System.out.println(MockData.getdata(3 * 1000, 5 * 1000));

    }
}
