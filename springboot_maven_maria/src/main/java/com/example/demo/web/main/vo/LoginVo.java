package com.example.demo.web.main.vo;


import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class LoginVo {
	
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
	
	
	
}
