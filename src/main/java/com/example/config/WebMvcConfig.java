package com.example.config;


import com.example.handle.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/");
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/member");
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/content");
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/profile");
//        registry.addInterceptor(securityInterceptor).addPathPatterns("/edit-content");
    }
}
