package com.example.demo.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.auth.mapper.AuthenticationMapper;
import com.example.demo.auth.vo.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiUserService {

	private String authNoSessionKey = "%s_%s_%s_%s";
	private static final String OPEN_NO_USER_AGENT = "Mozilla";

	@Autowired
	private AuthenticationMapper authMapper;

	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	//@Autowired
	//private AuthenticationService authenticationService;
	
	/**
	 * 회원정보 조회
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfo(String params) {
		return authMapper.getUserInfo(params);
	}
	
	
	/**
	 * 인증번호 발송(아이디 찾기, 비밀번호 찾기)
	 * @param param
	 * @return
	 
	public DataMap sendAuthNo(DataMap param) {
		String findType = param.getString("findType"); // ID, PW
		String authType = param.getString("authType");
		String userId = param.getString(Constants.UserInfo.USER_ID);
		String userNm = param.getString("userNm");
		String userInfo = param.getString("userInfo");
		
		UserInfo user = null;
		if ("ID".equals(findType)) {
			if ("hpAuth".equals(authType)) {
				user = authMapper.getUserInfoForFindId(userNm, userInfo, null, null);
			} else {
				user = authMapper.getUserInfoForFindId(userNm, null, userInfo, null);
			}
		} else {
			user = getUserInfo(userId);
			if (!userNm.equals(user.getUserNm())) {
				user = null;
			}
		}
		
		String succYn = "N";
		if (user != null && user.isEnabled()) {
			String authNo = RandomStringUtils.randomNumeric(6);
			if ("hpAuth".equals(authType)) {
				userInfo = user.getUserHpNo();
				String smsTxt = "[부동산114] " + ("ID".equals(findType) ? "아이디" : "비밀번호") + " 찾기 인증번호는 [" + authNo + "]입니다.";
				succYn = mmsService.sendSms(new Date(), userInfo.replace("-", ""), "0317070114", smsTxt) ? "Y" : "N";
			} 
			else if ("emailAuth".equals(authType)) {
				userInfo = user.getUserEmail();
				String subject = "부동산114 " + ("ID".equals(findType) ? "아이디" : "비밀번호") + " 찾기 인증번호 메일입니다.";
				succYn = emailComponent.sendEmail(userInfo, subject, authNo).equals("200") ? "Y" : "N";
			}
	
			log.debug("authNo ==> {}", authNo);
			
			String authKey = String.format(authNoSessionKey, findType, authType, userNm, userInfo);
			authenticationService.saveAuthNo(authKey, authNo);
			
			param.set("userYn", "Y");
		} else {
			param.set("userYn", "N");
		}
		param.set(Constants.SUCC_YN, succYn);
		return param;
	}*/
	
	/**
	 * 인증번호 확인(아이디 찾기, 비밀번호 찾기)
	 * @param param
	 * @return
	
	public DataMap verifyAuthNo(DataMap param) {
		return verifyAuthNo(null, param);
	} */
	
	/**
	 * 인증번호 확인(아이디 찾기, 비밀번호 찾기)
	 * @param request
	 * @param param
	 * @return
	 
	public DataMap verifyAuthNo(HttpServletRequest request, DataMap param) {
		String findType = param.getString("findType"); // ID, PW
		String authType = param.getString("authType");
		String userId = param.getString(Constants.UserInfo.USER_ID);
		String userNm = param.getString("userNm");
		String userInfo = param.getString("userInfo");
		String authNo = param.getString("authNo");
		
		UserInfo user = null;
		if ("ID".equals(findType)) {
			if ("hpAuth".equals(authType)) {
				user = authMapper.getUserInfoForFindId(userNm, userInfo, null, null);
			} else {
				user = authMapper.getUserInfoForFindId(userNm, null, userInfo, null);
			}
		} else {
			user = getUserInfo(userId);
		}
		
		if ("hpAuth".equals(authType)) {
			userInfo = user.getUserHpNo();
		} 
		else if ("emailAuth".equals(authType)) {
			userInfo = user.getUserEmail();
		}
		
		String authKey = String.format(authNoSessionKey, findType, authType, userNm, userInfo);
		String dbAuthNo = authenticationService.getAuthNo(authKey);
		if (authNo.equals(dbAuthNo)) {
			param.set(Constants.UserInfo.USER_ID, user.getUserId());
			param.set("joinDt",
					user.getJoinDt().format(DateTimeFormatter.ofPattern(Constants.FMT_YYYYMMDDHHMMSS_DASH)));
			param.set(Constants.SUCC_YN, Constants.IS_Y);
			
			if ("PW".equals(findType)) {
				if (request != null) {
					authenticationService.deleteAuthNo(authKey);
					HttpRequestUtil.setSessionAttribute(request, "CHANGE_PW_YN", Constants.IS_Y);
				}
			} else {
				authenticationService.deleteAuthNo(authKey);
			}
			
			return param;
		}
		
		param.set(Constants.SUCC_YN, Constants.IS_N);
		return param;
	}*/
	
	/**
	 * 본인인증으로 아이디/비밀번호 찾기
	 * @param request
	 * @param param
	 * @return
	
	public ResponseEntity<Object> verifyOkCert(HttpServletRequest request, DataMap param) {
		String userNm = param.getString("userNm");
		String okCertCd = param.getString("okCertCd"); // FIND_ID, FIND_PW
		String authCi = param.getString("okCertCi");
		
		UserInfo userInfo = authMapper.getUserInfoForFindId(userNm, null, null, authCi);
		String okCertCi = (String) HttpRequestUtil.getSessionAttribute(request, okCertCd);
		if (userInfo != null && authCi.equals(okCertCi)) {
			param.set(Constants.UserInfo.USER_ID, userInfo.getUserId());
			param.set("joinDt", userInfo.getJoinDt());
			
			HttpRequestUtil.removeSessionAttribute(request, okCertCi);
			
			if ("FIND_PW".equals(okCertCd)) {
				HttpRequestUtil.setSessionAttribute(request, "CHANGE_PW_YN", Constants.IS_Y);
			}
			return ApiResponseUtils.success(param);
		}
		return ApiResponseUtils.fail(param);
	} */
	
	/**
	 * 아이디 확인(비밀번호 찾기)
	 * @param request
	 * @param param
	 * @return
	 
	public DataMap verifyUserId(DataMap param) {
		UserInfo userInfo = getUserInfo(param.getString(Constants.UserInfo.USER_ID));
		if (userInfo != null && userInfo.isEnabled()) {
			param.set(Constants.SUCC_YN, "Y");
		} else {
			param.set(Constants.SUCC_YN, "N");
		}
		return param;
	}*/
	
	/**
	 * 회원정보 조회 후 마스킹 처리
	 * @param param
	 * @return
	 
	public DataMap getUserInfoMasking(DataMap param) {
		UserInfo userInfo = getUserInfo(param.getString(Constants.UserInfo.USER_ID));
		return getUserInfoMasking(userInfo, param);
	}*/
	
	/**
	 * 회원정보 조회 후 마스킹 처리
	 * @param param
	 * @return
	
	public DataMap getUserInfoMasking(UserInfo userInfo, DataMap param) {
		// 첫자리 빼고 전부 마스킹
		String[] userHpNoArr = userInfo.getUserHpNo().split("-");
		param.put("userHpNoMasking",
				MaskingUtil.maskRight(userHpNoArr[0], userHpNoArr[0].length() - 1) + "-"
						+ MaskingUtil.maskRight(userHpNoArr[1], userHpNoArr[1].length() - 1) + "-"
						+ MaskingUtil.maskRight(userHpNoArr[2], userHpNoArr[2].length() - 1));
		
		// 4자리 이후 마스킹
		String[] userEmailArr = userInfo.getUserEmail().split("@");
		param.put("userEmailMasking", MaskingUtil.maskRight(
				userEmailArr[0], userEmailArr[0].length() - 4) + "@" + userEmailArr[1]);
		
		return param;
	} */
	
	/**
	 * 비밀번호 변경하기
	 * @param param
	 * @return
	 
	public ResponseEntity<Object> setPassword(HttpServletRequest request, DataMap param) {
		if (CommonUtil.equalsIgnoreCase(ValidateUtil.isValidUserPw(param.getString(Constants.UserInfo.USER_PW)), "S", "M")) {
			if (SecurityUtil.isAuthenticated()
					&& CommonUtil.equals(SecurityUtil.getCurrentLoginUserId(), param.getString(Constants.UserInfo.USER_ID))) {
				setPassword(param);
				
				SecurityUtil.updateAuthentication(getUserInfo(SecurityUtil.getCurrentLoginUserId()));
				return ApiResponseUtils.success();
			} 
			else {
				
				String changePwYn = (String) HttpRequestUtil.getSessionAttribute(request, "CHANGE_PW_YN");
				if ("Y".equals(changePwYn)) {
					setPassword(param);
					HttpRequestUtil.removeSessionAttribute(request, "CHANGE_PW_YN");
					return ApiResponseUtils.success();
				}
			}
		}
		return ApiResponseUtils.fail();
	}*/
	
	/*
	private void setPassword(DataMap param) {
		param.put(Constants.UserInfo.USER_PW, passwordEncoder.encode(param.getString(Constants.UserInfo.USER_PW)));
		param.put("userPwChgDt", DateUtil.getNowDtToString());
		userDao.setPassword(param);
	}*/
	
	
	/**
	 * 아이디 중복체크 - 탈퇴회원 포함
	 * @param params
	 * @return
	 
	public ResponseEntity<Object> dupChkUserId(DataMap params) {
		UserInfo user = getUserInfo(params.getString(Constants.UserInfo.USER_ID));
		params.set("userIdDupYn", (user != null ? "Y" : "N"));
		return ApiResponseUtils.success(params);
	}*/
	
	/**
	 * 회원가입
	 * @param corpNoFile
	 * @param openNoFile
	 * @param param
	 * @return
	 
	public ResponseEntity<Object> userJoin(HttpServletRequest request, MultipartFile corpNoFile,
			MultipartFile openNoFile, Map<String, Object> param) {
		try {
			DataMap paramMap = new DataMap(param);
			
			// 아이디 공백제거
			String userId = paramMap.getString(Constants.UserInfo.USER_ID).trim();
			if (!ValidateUtil.isValidUserId(userId)) {
				return ApiResponseUtils.fail("아이디는 영문 또는 숫자 가능하며, 6~15자로 입력해주세요.");
			}
			
			String userPw = paramMap.getString(Constants.UserInfo.USER_PW);
			if ("W".equalsIgnoreCase(ValidateUtil.isValidUserPw(userPw))) {
				return ApiResponseUtils.fail("비밀번호는 영문, 숫자, 특수문자를 포함한 8자~20자로 입력해주세요.");
			}
			userPw = passwordEncoder.encode(userPw);
			
			// 이메일 주소
			String emailDomain = paramMap.getString("userEmail2");
			if (CommonUtil.isNotEmpty(paramMap.getString(Constants.SysCode.EMAIL_DOMAIN))) {
				emailDomain = paramMap.getString(Constants.SysCode.EMAIL_DOMAIN);
			}
			String userEmail = paramMap.getString("userEmail1") + "@" + emailDomain; 
			
			// 휴대폰번호
			String brokerageHpNo = paramMap.getString("brokerageHpNo1") + "-" + paramMap.getString("brokerageHpNo2")
					+ "-" + paramMap.getString("brokerageHpNo3");
			
			// 본인인증한 이력 확인하기
			String authResult = (String) HttpRequestUtil.getSessionAttribute(request, paramMap.getString("okCertCd"));
			if (!paramMap.getString("okCertCi").equals(authResult)) {
				return ApiResponseUtils.fail("휴대폰 본인인증 결과가 없습니다.");
			}
			if (profile.isProd() && !paramMap.getString("repNm").equals(paramMap.getString("rsltName"))) {
				return ApiResponseUtils.fail("본인인증한 이름과 대표자명이 일치하지 않습니다.");
			}
			
			// 전화번호
			String userTelNo = null;
			if (CommonUtil.isNotEmpty(paramMap.getString("brokerageTelNo1"))
					&& CommonUtil.isNotEmpty(paramMap.getString("brokerageTelNo2"))
					&& CommonUtil.isNotEmpty(paramMap.getString("brokerageTelNo3"))) {
				userTelNo = paramMap.getString("brokerageTelNo1") + "-" + paramMap.getString("brokerageTelNo2") + "-"
						+ paramMap.getString("brokerageTelNo3");
			}
			
			// 팩스번호
			String userFaxNo = null;
			if (CommonUtil.isNotEmpty(paramMap.getString("brokerageFaxNo1"))
					&& CommonUtil.isNotEmpty(paramMap.getString("brokerageFaxNo2"))
					&& CommonUtil.isNotEmpty(paramMap.getString("brokerageFaxNo3"))) {
				userFaxNo = paramMap.getString("brokerageFaxNo1") + "-" + paramMap.getString("brokerageFaxNo2") + "-"
						+ paramMap.getString("brokerageFaxNo3");
			}
			
			// 주소정보 순번을 구하기 위한 주소정보(공백없어야 함)
			String addrInfo = paramMap.getString("addrSido") + paramMap.getString("addrSigugun")
					+ paramMap.getString("addrDongmyun") + paramMap.getString("addrRi");
			addrInfo = addrInfo.replace(" ", "");
			
			// 사업자등록증 파일
			int corpNoFileNo = insertUserFile(corpNoFile, userId, FileDomain.USER);
			
			// 개설등록증 파일
			int openNoFileNo = 0;
			if (!openNoFile.isEmpty()) {
				openNoFileNo = insertUserFile(openNoFile, userId, FileDomain.USER);
			}
			
			UserJoinVo userJoinVo = UserJoinVo.builder()
					.userId(userId.toLowerCase())
					.userPw(userPw)
					.userNm(paramMap.getString("repNm"))
					.userHpNo(brokerageHpNo)
					.userTelNo(userTelNo)
					.userFaxNo(userFaxNo)
					.userEmail(userEmail)
					.empNo(paramMap.getInt("empNo"))
					.joinType("Y".equals(paramMap.getString("searchYn")) ? 1 : 2)
					.joinStatus("Y".equals(paramMap.getString("searchYn")) ? 1 : 2)
					.authCi(authResult)
					.corpNo(paramMap.getString("corpNo1") 
							+ "-" + paramMap.getString("corpNo2") + "-" + paramMap.getString("corpNo3"))
					.openNo(StringUtils.defaultIfEmpty(paramMap.getString("openNo"), null))
					.brokerNm(paramMap.getString("brokerageNm"))
					.zipCode(paramMap.getString("zipCode"))
					.jibunAddr(paramMap.getString("jibunAddr"))
					.roadAddr(paramMap.getString("roadAddr"))
					.detailAddr(paramMap.getString("detailAddr"))
					.addrX(paramMap.getString("addrX"))
					.addrY(paramMap.getString("addrY"))
					.addrInfo(addrInfo)
					.adAddrType(paramMap.getString("addrRadioNm").equalsIgnoreCase("road") ? 2 : 1)
					.adTelNoYn(paramMap.containsKey("brokerageTelNoCheck") ? "Y" : "N")
					.adHpNoYn(paramMap.containsKey("brokerageHpNoCheck") ? "Y" : "N")
					.corpNoFileNo(corpNoFileNo)
					.openNoFileNo(openNoFileNo)
					.createDt(DateUtil.getNowDtToString())
					.build();
			
			int userNo = userDao.userJoin(userJoinVo);
			log.info("userNo: " + userNo);
			
			if (userNo < 0) {
				return ApiResponseUtils.fail();
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			return ApiResponseUtils.fail(e.getLocalizedMessage());
		}
		
		return ApiResponseUtils.success();
	}*/

}
