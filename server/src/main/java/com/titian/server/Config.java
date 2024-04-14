package com.titian.server;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Getter
public class Config implements WebMvcConfigurer {

    //@Value可以将配置文件的内容自动注入到属性内
    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoPath;   //图标物理存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath;   //图标映射路径

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(ProfilePhotoMapperPath+"**").addResourceLocations("file:"+ProfilePhotoPath);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://47.93.77.117:8088/") // 修改为您的前端应用的实际地址
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false)
                .maxAge(3600)
                .allowedHeaders("*");
    }

}

