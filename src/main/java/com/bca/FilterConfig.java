package com.bca;

import com.bca.middlewares.SessionFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

  @Bean
  public FilterRegistrationBean<SessionFilter> urlFilter() {
    FilterRegistrationBean<SessionFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new SessionFilter());
    registrationBean.addUrlPatterns("/admin/dashboard");
    registrationBean.addUrlPatterns("/profile/*");

    return registrationBean;
  }
}
