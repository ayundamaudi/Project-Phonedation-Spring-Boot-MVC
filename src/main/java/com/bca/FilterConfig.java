package com.bca;

import com.bca.middlewares.AdminFilter;
import com.bca.middlewares.CustomerFilter;
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

  @Bean
  public FilterRegistrationBean<CustomerFilter> customerFilter() {
    FilterRegistrationBean<CustomerFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new CustomerFilter());
    registrationBean.addUrlPatterns("/profile/*");
    registrationBean.addUrlPatterns("/product/**/addtocart");
    registrationBean.addUrlPatterns("/product/**/addtowishlist");

    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<AdminFilter> adminFilter() {
    FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new AdminFilter());
    registrationBean.addUrlPatterns("/admin/*");

    return registrationBean;
  }
}
