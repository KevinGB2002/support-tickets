package com.kevin.support_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                     // para todas las rutas
                .allowedOrigins("http://localhost:5173") // permite Vue
                .allowedMethods("*")                    // GET, POST, PUT, DELETE...
                .allowCredentials(true);               // si envías cookies o headers auth
    }
}
