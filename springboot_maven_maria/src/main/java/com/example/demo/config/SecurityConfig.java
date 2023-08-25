package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.auth.filter.SecurityAuthenticationFilter;
import com.example.demo.auth.service.AuthenticationService;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Value("${remember.me.cookie.validity.seconds}")
	//private int rememberMeCookieValiditySeconds;

	//@Autowired
	//private ApiLoginService loginService;

	@Autowired
	private AuthenticationService authenticationService;

	//@Autowired
	//private AccessDeniedPreHandler accessDeniedHandler;

	//@Autowired
	//private LogoutPreHandler logoutPreHandler;

	//@Bean
	//public LoggingFilter loggingFilter() {
		//return new LoggingFilter();
	//}

	// BCrypt를 이용한 비밀번호 해싱
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	// TODO bbs - 로그인 유지에 대한 key UUID로 생성해서 넣기 or 정하기(uniqueAndSecret)
	/*@Bean
	public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
		TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("bbsRememberMeKey", authenticationService);
		rememberMeServices.setTokenValiditySeconds(rememberMeCookieValiditySeconds);
		return rememberMeServices;
	}*/

	// 특정 요청에 대해 spring security를 무시 하려는 경우 설정
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		web.ignoring().antMatchers("/static/**", "/css/**", "/js/**", "/images/**", "/error/**", "/fonts/**");
	}

	// 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
	}
	
	// 스프링 시큐리티가 사용자를 인증하는 방법이 담긴 객체
	//@Override
	//public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
		//authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider());
	//}	

	// 취약점에 대한 방어가 필요한 end point 설정
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
				.disable()

			// CSRF를 비활성화하면 JSESSIONID가 생성되지 않음
			.csrf()
				.ignoringAntMatchers(
						"/login", 
						"/main",
						"/logout",
						"/error/**", 
						"/sample/**",
						"/api/sample/**", 
						"/api/callManager/**", 
						"/api/visualCall/**",
						"/api/mobile/**",
						"/api/mypage/**",
						"/callManager/**", 
						"/visualCall/**",
						"/common/popup/nicePay/**",
						"/**/**/preview",
						"/nameCard/**",
						"/api/interface/**")
				.and()

			.exceptionHandling()
				//.accessDeniedHandler(accessDeniedHandler)
				.and()

			.authorizeRequests()
				.antMatchers("/**").permitAll() //접근허용
				.and()
			.formLogin() // 로그인하는 경우에 대해 설정
				.loginPage("/loginPage") // 로그인 페이지 URL을 설정
				.loginProcessingUrl("/login")
				.successForwardUrl("/main") // 로그인 성공 후 이동할 URL 설정
				.failureForwardUrl("/test") // 로그인 실패 URL 설정
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				//.addLogoutHandler(logoutPreHandler)
				.and()

			//.rememberMe()
				//.rememberMeServices(tokenBasedRememberMeServices())
				//.and()

			//.addFilter(new JwtUsernamePasswordAuthenticationFilter(
					//loginService, authenticationService, tokenBasedRememberMeServices()))
			.addFilterBefore(new SecurityAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
			//.addFilterBefore(loggingFilter(), WebAsyncManagerIntegrationFilter.class);
	}

	/**
	 * Cors configuration source cors configuration source. Cors 허용 옵션 설정 부분
	 *
	 * @return the cors configuration source
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "TOKEN_ID", "X-Requested-With", "Authorization",
				"Content-Type", "Content-Length", "Cache-Control"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}