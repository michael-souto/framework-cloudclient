package br.com.detrasoft.framework.feignclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.detrasoft.framework.security.context.UsuarioContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class AuthorizationHeaderConfig {

	@Bean
	public RequestInterceptor bearerTokenRequestInterceptor() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate template) {
				template.header("Authorization", String.format("Bearer %s", UsuarioContext.getToken()));
			}
		};
	}
}
