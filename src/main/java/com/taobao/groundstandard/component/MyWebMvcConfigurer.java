/**
 * @program: ground-standard
 * @description:
 * @author: jojo
 * @create: 2020-06-09 22:10
 **/

package com.taobao.groundstandard.component;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("login");
        registry.addViewController("/user/login").setViewName("login");
        registry.addViewController("/user/regist").setViewName("regist");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/manager/login").setViewName("login_manager");
        registry.addViewController("/manager/stall/list").setViewName("stall/index_manager");
        registry.addViewController("/manager/uselist").setViewName("use_manager");
        registry.addViewController("/manager/add").setViewName("stall/add");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/user/**")
                .excludePathPatterns("/user/regists","/user/regist","/user/userinfo", "/user/tologin", "/user", "/user/login", "/error", "/webjars/**", "/asserts/**");
        registry.addInterceptor(new ManagerInterceptor()).addPathPatterns("/manager/**")
                .excludePathPatterns("/manager/login","/manager/managerinfo", "/error", "/webjars/**", "/asserts/**");
    }
}
