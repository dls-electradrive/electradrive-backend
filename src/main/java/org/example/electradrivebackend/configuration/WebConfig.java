package org.example.electradrivebackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class WebConfig {

    private static final String CORS_ORIGIN = "https://icy-forest-0d018a503.5.azurestaticapps.net";

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("Applying CORS configuration.");
                registry.addMapping("/api/**")
                        .allowedOrigins(CORS_ORIGIN)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("Authorization, Content-Type")
                        .allowCredentials(true);
            }
        };
    }

    @Bean
    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ApiKeyFilter());
        registrationBean.addUrlPatterns("/api/*");
        System.out.println("Registering ApiKeyFilter for /api/* paths.");
        return registrationBean;
    }
}
