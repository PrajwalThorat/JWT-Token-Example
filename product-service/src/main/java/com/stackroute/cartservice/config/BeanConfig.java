package com.stackroute.cartservice.config;


import com.stackroute.cartservice.security.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JwtFilter());
        bean.addUrlPatterns("/api/v1/product/*");
        return bean;
    }
}
