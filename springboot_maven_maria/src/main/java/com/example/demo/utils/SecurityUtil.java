package com.example.demo.utils;

import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.auth.vo.UserInfo;


public class SecurityUtil {

	public static final String ANONYMOUS = "ROLE_ANONYMOUS";

	private SecurityUtil() {
		throw new IllegalStateException("Utility Class");
	}

	/**
	 * 현재 로그인 유저 아이디 조회
	 * 
	 * @return
	 */
	public static String getCurrentLoginUserId() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Optional<String> result = Optional.ofNullable(securityContext.getAuthentication()).map(authentiation -> {
			if (authentiation.getPrincipal() instanceof UserDetails) {
				UserInfo user = (UserInfo) authentiation.getPrincipal();
				return user.getUserId();
			} else if (authentiation.getPrincipal() instanceof String) {
				return (String) authentiation.getPrincipal();
			}
			return null;
		});
		return result.isPresent() ? result.get() : null;
	}

	/**
	 * 현재 로그인 유저명 조회
	 * 
	 * @return
	 */
	public static String getCurrentLoginUserNm() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Optional<String> result = Optional.ofNullable(securityContext.getAuthentication()).map(authentiation -> {
			if (authentiation.getPrincipal() instanceof UserDetails) {
				UserInfo user = (UserInfo) authentiation.getPrincipal();
				return user.getUserNm();
			} else if (authentiation.getPrincipal() instanceof String) {
				return (String) authentiation.getPrincipal();
			}
			return null;
		});
		return result.isPresent() ? result.get() : null;
	}

	/**
	 * 현재 로그인 유저 정보 조회
	 * 
	 * @return
	 */
	public static UserInfo getCurrentLoginUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Optional<UserInfo> result = Optional.ofNullable(securityContext.getAuthentication()).map(authentiation -> {
			if (authentiation.getPrincipal() instanceof UserDetails) {
				return (UserInfo) authentiation.getPrincipal();
			}
			return null;
		});
		return (result.isPresent()) ? result.get() : null;
	}
	
	/**
	 * 현재 로그인 유저 정보 조회(빈값 전달)
	 * 
	 * @return
	 */
	public static UserInfo getCurrentLoginUserNotNull() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Optional<UserInfo> result = Optional.ofNullable(securityContext.getAuthentication()).map(authentiation -> {
			if (authentiation.getPrincipal() instanceof UserDetails) {
				return (UserInfo) authentiation.getPrincipal();
			}
			return null;
		});
		return (result.isPresent()) ? result.get() : new UserInfo();
	}

	/**
	 * 로그인 인증 여부
	 * 
	 * @return
	 */
	public static boolean isAuthenticated() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional.ofNullable(securityContext.getAuthentication())
				.map(authentication -> authentication.getAuthorities().stream()
						.noneMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(ANONYMOUS)))
				.orElse(false);
	}

	/**
	 * 현재 로그인 유저 권한 여부
	 * 
	 * @param authority
	 * @return
	 */
	public static boolean isCurrentUserInRole(String authority) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional
				.ofNullable(securityContext.getAuthentication()).map(authentication -> authentication.getAuthorities()
						.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
				.orElse(false);
	}
	
	/**
	 * 사용자 정보 갱신
	 * 
	 * @param userInfo
	 */
	public static void updateAuthentication(UserInfo userInfo) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userInfo, authentication.getCredentials(), userInfo.getAuthorities());
		usernamePasswordAuthenticationToken.setDetails(authentication.getDetails());
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	}

}
