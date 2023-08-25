package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * com.mih.career.common.config
 *    |_ WebConfig.java
 *
 * </pre>
 *
 * @author : mih
 * @Date : 2021/02/08
 * @프로그램 설명   :
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.img.location}")
    private String resourcesLocation;
    @Value("${file.location}")
    private String resourcesUriPath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcesUriPath + "/**")
                .addResourceLocations("file://" + resourcesLocation);

    }
}