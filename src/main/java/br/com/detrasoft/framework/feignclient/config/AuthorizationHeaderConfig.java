package br.com.detrasoft.framework.feignclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;

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
				template.header(HttpHeaders.ACCEPT_LANGUAGE, LocaleContextHolder.getLocale().toString());
				if (UsuarioContext.getIdUsuario() == null) {
					template.header("enviroment", UsuarioContext.getIdDetrasoft().toString());
				} else {
					template.header(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", UsuarioContext.getToken()));
				}
			}
		};
	}
}
