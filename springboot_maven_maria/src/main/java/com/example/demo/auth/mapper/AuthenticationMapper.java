package com.example.demo.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.auth.vo.UserInfo;

@Repository
@Mapper
public interface AuthenticationMapper {
	
	/**
	 * 사용자정보 조회(중개회원 및 중개업소 - 다구좌계정 포함)
	 * @param userId
	 * @param userNo
	 * @return
	 */
	public UserInfo getUserInfo(String params);

	
}
