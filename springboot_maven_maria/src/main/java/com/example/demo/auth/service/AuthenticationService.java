package com.example.demo.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.auth.mapper.AuthenticationMapper;
import com.example.demo.auth.vo.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {
	
	@Value("${session.max.inactive.interval}")
	public int sessionMaxInactiveInterval;

	//@Autowired
	//private JwtAuthTokenProvider jwtAuthTokenProvider;

	//@Autowired
	//private JwtConfig jwtConfig;

	//@Autowired
	//private AuthenticationMapper mapper;
	
	@Autowired
	private ApiUserService apiUserService;

	@Override
	public UserDetails loadUserByUsername(String userId) throws AuthenticationException {
		UserInfo userInfo = apiUserService.getUserInfo(userId);
		if (userInfo == null) {
			throw new UsernameNotFoundException("계정 없음...");
		}
		return userInfo;
	}

	/**
	 * JWT 토큰 발급(Access/Refresh Token) - Header 셋팅
	 * AccessToken - 기본 24hour(86400sec)
	 * RefreshToken - AccessToken 갱신용(7day): 604800
	 * APP자동로그인이면 AccessToken을 7day로 만들기
	 *
	 * @param userInfo
	 * @param response
	 
	public ApiTokenVo tokenProcess(UserInfo userInfo, HttpServletResponse response, String existRefreshToken) {
		if (log.isDebugEnabled()) {
			log.debug("## Token Expiration :: Access({}), Refresh({})", jwtConfig.getAccessTokenExpiration(),
					jwtConfig.getRefreshTokenExpiration());
		}
		
		String accessToken = ((JwtAuthToken) createAuthToken(userInfo, true)).getToken();
		String refreshToken = CommonUtil.isNotEmpty(existRefreshToken) ? existRefreshToken
				: ((JwtAuthToken) createAuthToken(userInfo, false)).getToken();
		if (log.isDebugEnabled()) {
			log.debug("## AccessToken :: {}", accessToken);
			log.debug("## RefreshToken :: {}", refreshToken);
		}
		
		// Header 셋팅
		response.addHeader(Constants.X_BBS_AT, accessToken);
		response.addHeader(Constants.X_BBS_RT, refreshToken);
		
		ApiTokenVo tokenVo = new ApiTokenVo();
		tokenVo.setUserId(userInfo.getUserId());
		tokenVo.setUserNo(userInfo.getUserNo());
		tokenVo.setBrokerageCd(userInfo.getBrokerageCd());
		tokenVo.setRequestType(userInfo.getRequestType().name());
		tokenVo.setAccessToken(accessToken);
		tokenVo.setRefreshToken(refreshToken);
		
		// 토큰 정보 저장
		saveApiTokenVo(tokenVo);
		
		return tokenVo;
	}*/

	/**
	 * JWT 토큰 발급(AccessToken/RefreshToken)
	 *
	 * @param userInfo
	 * @param isAccessToken
	 * @return
	 
	@SuppressWarnings("rawtypes")
	private AuthToken createAuthToken(UserInfo userInfo, boolean isAccessToken) {
		int plusSeconds = isAccessToken ? jwtConfig.getAccessTokenExpiration() : jwtConfig.getRefreshTokenExpiration();
		Date expiredDate = Date
				.from(LocalDateTime.now().plusSeconds(plusSeconds).atZone(ZoneId.systemDefault()).toInstant());
		return jwtAuthTokenProvider.createAuthToken(userInfo, expiredDate);
	}*/
	
	/**
	 * 토큰 저장
	 * @param tokenVo
	
	public void saveApiTokenVo(ApiTokenVo tokenVo) {
		tokenVo.setCreateDt(DateUtil.getNowDtToString());
		if (mapper.getUserToken(tokenVo.getUserId(), tokenVo.getRequestType()) != null) {
			mapper.updateUserToken(tokenVo);
		} else {
			mapper.insertUserToken(tokenVo);
		}
	} */
	
	/**
	 * 토큰 조회
	 * @param userId
	 * @param requestType
	 * @return
	 
	public ApiTokenVo getApiTokenVo(String userId, String requestType) {
		return mapper.getUserToken(userId, requestType);
	}*/
	
	/**
	 * 토큰 삭제
	 * @param tokenVo
	 
	public void deleteApiTokenVo(ApiTokenVo tokenVo) {
		tokenVo.setCreateDt(DateUtil.getNowDtToString());
		mapper.updateUserToken(tokenVo);
	}*/
	
	/**
	 * 인증번호 조회
	 * @param authKey
	 * @return
	 
	public String getAuthNo(String authKey) {
		return mapper.getAuthNo(authKey);
	}*/
	
	/**
	 * 인증번호 등록, 수정
	 * @param authKey
	 * @param authNo
	 
	public void saveAuthNo(String authKey, String authNo) {
		if (CommonUtil.isNotEmpty(getAuthNo(authKey))) {
			mapper.setAuthNo("U", authKey, authNo, DateUtil.getNowDtToString());
		} else {
			mapper.setAuthNo("I", authKey, authNo, DateUtil.getNowDtToString());
		}
	}*/
	
	/**
	 * 인증번호 삭제
	 * @param authKey
	 * @param authNo
	 
	public void deleteAuthNo(String authKey) {
		mapper.setAuthNo("D", authKey, null, DateUtil.getNowDtToString());
	}*/
	
}
