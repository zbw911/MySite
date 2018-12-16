package com.zhangbaowei.demo.schedulings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class tomcatmomitor {

    @Autowired
    private MetricsEndpoint metricsEndpoint;

    @Scheduled(fixedRate = 1000)
    public void fixedRate() {

        MetricsEndpoint.ListNamesResponse listNamesResponse = metricsEndpoint.listNames();

        MetricsEndpoint.MetricResponse metric = metricsEndpoint.metric("tomcat.threads.busy", null);

        Double value = metric.getMeasurements().get(0).getValue();

        String join = String.join("\r\n", listNamesResponse.getNames());
        System.out.println(value);
       // System.out.println(join);

    }

}
