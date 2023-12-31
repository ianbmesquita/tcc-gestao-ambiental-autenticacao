package br.pucmg.sigam.autenticacao.infra.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://pxk2kufc4a.execute-api.sa-east-1.amazonaws.com")
//                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
                        .allowCredentials(true);
            }
        };
    }
}
