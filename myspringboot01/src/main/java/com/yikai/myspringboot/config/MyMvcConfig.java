package com.yikai.myspringboot.config;

import com.yikai.myspringboot.component.LoginHandlerInterceptor;
import com.yikai.myspringboot.component.MyLocale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author wangyikai
 * @Date 2018/9/13 - 14:41
 */
//来扩展springmvc的功能   既能保留原有配置，也能保留扩展配置
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        浏览器发送yikai请求，请来到success页面
        registry.addViewController("/yikai").setViewName("success");
    }


    @Bean
    public  WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//            注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//              静态资源已经被springboot处理好，不用你来做
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return  adapter;

    }


    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocale();
    }

}
