package com.zhangbaowei.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ScatterTest {
    @Test
    public void name() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(1);


        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);

        list.add(1);

        list.add(3);
        list.add(3);

        list.add(2);
        list.add(2);
        list.add(2);

        // 1 , 0 , 2 , 3
        // 2 , 3 , 6  ,4
        // 1 , 7 , 7 , 4
        // 3 , 8 , 9 , 2
        // 2 , 10 ,12 ,3

        ScatterList(list, 2);


    }

    @Test
    public void TimeTest() {

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() + (30l * 24 * 3600 * 1000));
        System.out.println(30d * 24 * 3600 * 1000);
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println(sqlDate.toString()); // 输出结果：2015-06-25

        sqlDate = new java.sql.Date(System.currentTimeMillis() + (30l * 24 * 3600 * 1000));
        System.out.println(sqlDate.toString()); // 输出结果：2015-06-25
    }


    private void ScatterList(List<Integer> list, int maxSame) {
        System.out.println("SameCount=" + maxSame);
        System.out.print("原" + "=>\t");
        list.stream().forEach(x -> System.out.print(x + "\t"));
        System.out.println();

        int MAX_SAMECOUNT = maxSame;

        int samecount = 1;
        int lasttype = -1;

        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);

            if (integer == lasttype) {
                samecount++;
            } else {
                lasttype = integer;
                samecount = 1;
            }

            if (samecount > MAX_SAMECOUNT) {
                int diffrentIndex = findDiffrent(list, i, lasttype);

                if (diffrentIndex != -1) {
                    list.set(i, list.get(diffrentIndex));
                    list.set(diffrentIndex, lasttype);
                    i++;
                } else {
                    break;
                }
            }
            System.out.print(i + "=>\t\t");
            list.stream().forEach(x -> System.out.print(x + "\t"));
            System.out.println();

        }

        System.out.print("完" + "=>\t");
        list.stream().forEach(x -> System.out.print(x + "\t"));
        System.out.println();
    }


    private int findDiffrent(List<Integer> list, int from, int type) {
        for (int i = from; i < list.size(); i++) {
            if (list.get(i) == type) {
                continue;
            }
            return i;
        }
        return -1;
    }

}
