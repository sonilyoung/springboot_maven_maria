package com.example.demo.auth.vo;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo implements UserDetails {

	private static final long serialVersionUID = -6672307969434223779L;

	private Long userNo;                     
	private String userId;                            
    private String userNm;                            
    private String userPw;                    
    private String authCd;                            
    private String dept;                              
    private String telNo;                             
    private String hpNo;                              
    private String email;                             
    private String firstLogin;                        
    private String lastLogin;                         
    //private String loginError;                      
    private String prePw;                             
    private String pwChangeDay;                       
    private String pwChangeCycle;                     
    private String pwChangePeriod;                    
    private String useYn;                              
    private String regId;                              
    private String regDt;                              
    private String updId;                              
    private String updDt;                              
    //private String autoPlus;                         
    private String delYn;                              
    private String delDt;   

	@Override
	public String getPassword() {
		return this.userPw;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}

	/**
	 * 계정 잠금 여부 (True: 정상)
	 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}*/

	/**
	 * 계정 비밀번호 만료 여부 (True: 정상)
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	} */

	/**
	 * 계정 활성화 여부 (True: 정상)
	 
	@Override
	public boolean isEnabled() {
		return !Constants.IS_Y.equals(this.withdrawYn);
	}
	
	public String getUserNoString() {
		return String.valueOf(this.userNo);
	}*/
	
	/**
	 * 회원구분(권한)
	 * @return
	 */
	public String getUserRole() {
		//TODO 메뉴권한 정해지면 아래 값으로 처리하기
		//return UserRoleType.of(this.userRole).name();
		return this.authCd;
	}
	
	
	/**
	 * 패스워드 변경 필요여부(90일 기준)
	 * @return
	 
	public boolean isPwChgRequired() {
		if (SecurityUtil.isAuthenticated()) {
			return this.userPwChgDt.isBefore(DateUtil.getMinusDayNowDt(90));
		} else {
			return false;
		}
	}*/

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(new String[] { this.getUserRole() }).map(SimpleGrantedAuthority :: new)
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}