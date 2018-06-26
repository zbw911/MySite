package com.zhangbaowei.demo.core;

import com.zhangbaowei.demo.core.qq.MyApplicationContextAware;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 配置忽略路径大小写
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }


    /*FilterRegistrationBean 用来配置urlpattern 来确定哪些路径触发filter */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(AuthFilter());
        registration.addUrlPatterns("/api/*");
        registration.setOrder(1);
        return registration;
    }

    /*使用annotation tag来取代<bean></bean>*/
    @Bean()
    public javax.servlet.Filter AuthFilter() {
        return new CaseInsensitiveRequestFilter();
    }


    @Bean(name = "myApplicationContextAware", initMethod = "init", destroyMethod = "destroy")
    public MyApplicationContextAware xxlJobDynamicScheduler(FilterRegistrationBean filterRegistrationBean) throws Exception {
        MyApplicationContextAware myApplicationContextAware = new MyApplicationContextAware();

        return myApplicationContextAware;
    }
}