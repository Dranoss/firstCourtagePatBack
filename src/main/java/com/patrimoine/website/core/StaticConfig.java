package com.patrimoine.website.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableWebMvc
public class StaticConfig implements WebMvcConfigurer {

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = null;
        try {
            path = "file:///" + new File("./uploads/").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        registry.addResourceHandler("/accessible/**")
                .addResourceLocations("classpath:/uploads/", path);
    }*/

}