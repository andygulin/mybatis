package com.mybatis.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic springServlet = servletContext.addServlet("springServlet", new DispatcherServlet());
        springServlet.setLoadOnStartup(1);
        springServlet.setInitParameter("contextConfigLocation", "classpath*:/spring-mvc.xml");
        springServlet.addMapping("/");

        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter("UTF-8", true));
        encodingFilter.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/*");

        servletContext.setInitParameter("contextConfigLocation", "classpath*:/applicationContext.xml");
        servletContext.addListener(ContextLoaderListener.class);
    }
}