package com.swagger.bootstrap.ui.demo.core;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * spring boot专用，避免继承webconfigurationsupport对spring的自动配置侵入和破坏
 * @author hanchao
 * @date 2018/3/9 12:07
 */
public class CustomWebMvcRegistrations implements WebMvcRegistrations {
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }

    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        return null;
    }

    public ExceptionHandlerExceptionResolver getExceptionHandlerExceptionResolver() {
        return null;
    }
}
