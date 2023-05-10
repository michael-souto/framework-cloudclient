package com.detrasoft.framework.cloudclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;

import com.detrasoft.framework.core.context.GenericContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class AuthorizationHeaderConfig {

	@Bean
	public RequestInterceptor bearerTokenRequestInterceptor() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate template) {
				template.header(HttpHeaders.ACCEPT_LANGUAGE, LocaleContextHolder.getLocale().toString());
				if (GenericContext.getContexts("tenant") != null) {
					template.header(
							"tenant",
							GenericContext.getContexts("tenant").toString());
				} else if (GenericContext.getContexts("token") != null){
					template.header(
							HttpHeaders.AUTHORIZATION,
							String.format("Bearer %s", GenericContext.getContexts("token").toString()));
				}
			}
		};
	}
}
