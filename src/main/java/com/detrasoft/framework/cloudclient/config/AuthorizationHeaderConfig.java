package com.detrasoft.framework.cloudclient.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AuthorizationHeaderConfig {

    @Bean
    public RequestInterceptor bearerTokenRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header(HttpHeaders.ACCEPT_LANGUAGE, LocaleContextHolder.getLocale().toString());
                if (RequestContextHolder.getRequestAttributes() != null && RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes) {
                    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                    String authorization = request.getHeader("Authorization");
                    if (StringUtils.isNotBlank(authorization)) {
                        template.header("Authorization", new String[]{authorization});
                    }
                }
            }
        };
    }
}

