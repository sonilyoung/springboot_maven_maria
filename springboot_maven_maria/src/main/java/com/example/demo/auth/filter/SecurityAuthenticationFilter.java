package com.example.demo.auth.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.utils.Constants;
import com.example.demo.utils.SecurityUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * SecurityContextHolder 인증여부 확인하는 필터
 */
@Slf4j
public class SecurityAuthenticationFilter extends OncePerRequestFilter {
	
	private final AntPathMatcher pathMatcher = new AntPathMatcher();
	
	/**
	 * 인증 여부 체크 URL 리스트
	 */
	private final List<String> authCheckURIList = Stream.of(
			"/main/**", 			
			"/main"
			).collect(Collectors.toList());
	
	private boolean isPathMatch(String requestUri) {
		for (String authCheckUri : authCheckURIList) {
			if (pathMatcher.match(authCheckUri, requestUri)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 특정 url 패턴에 따라 필터를 적용하기 위한 처리를 하는 메소드 (TRUE: filter 적용안함)
	 */
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		boolean isShouldNotFilter = true;
		// 선언된 URI와 일치하면 필터 적용
		if (isPathMatch(request.getRequestURI())) {
			isShouldNotFilter = false;
		}
		return isShouldNotFilter;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean authSuccess = false;
		
		boolean isAuthenticated = SecurityUtil.isAuthenticated();
		if (isAuthenticated) {
			/*if (SecurityUtil.getCurrentLoginUser().isPwChgRequired()) {
				String redirectUrl = request.getParameter("redirectUrl");
				String chgPwdUrl = Constants.LOGIN_PAGE_URL;
				if (!CommonUtil.isEmpty(redirectUrl)) {
					chgPwdUrl += "?redirectUrl=" + redirectUrl;
				}
				response.sendRedirect(chgPwdUrl);
			} 
			else {
				authSuccess = true;
			}*/
			
			authSuccess = true;
		} 
		else {
			String requestUri = request.getRequestURI();
			String loginUrl = Constants.LOGIN_PAGE_URL;
			
			log.info("## uri: {}, isAuthenticated: {}, isJson: {}", requestUri, isAuthenticated);
		
			String redirectUrl = loginUrl + "?redirectUrl=" + requestUri;
			response.sendRedirect(redirectUrl);
		}
		
		if (authSuccess) {
			filterChain.doFilter(request, response);
		}
	}

}