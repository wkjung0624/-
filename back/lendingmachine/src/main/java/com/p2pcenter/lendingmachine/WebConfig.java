package com.p2pcenter.lendingmachine;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private HttpSession session;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:3000") // 이 부분을 적절히 수정하여 필요한 도메인만 허용할 수 있습니다.
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true); // 인증 정보 허용

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        int secondsInOneYear = 60 * 60; // 1시간 초
        session.setMaxInactiveInterval(secondsInOneYear);
    }
}