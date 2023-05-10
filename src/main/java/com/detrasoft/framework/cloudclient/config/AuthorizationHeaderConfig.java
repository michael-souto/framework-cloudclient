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
				if (RequestContextHolder.getRequestAttributes() != null && RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes) {
					HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
					String authorization = request.getHeader("Authorization");
					if (StringUtils.isNotBlank(authorization)) {
						template.header("Authorization", new String[]{authorization});
					}
				}
			}
		};
	}
}
