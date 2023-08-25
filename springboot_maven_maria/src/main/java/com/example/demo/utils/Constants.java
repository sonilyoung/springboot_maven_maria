/*******************************************************************************
 *
 * Copyright ⓒ 2018 kth corp. All rights reserved.
 *
 * This is a proprietary software of kt corp, and you may not use this file except in
 * compliance with license agreement with kt corp. Any redistribution or use of this
 * software, with or without modification shall be strictly prohibited without prior written
 * approval of kt corp, and the copyright notice above does not evidence any actual or
 * intended publication of such software.
 *
 *******************************************************************************/
package com.example.demo.utils;

public class Constants {
	private Constants() {
		throw new IllegalStateException("Utility class");
	}
	public static final String DOT        = ".";
	public static final String REGEXP_DOT = "\\.";
	public static final String COMMA	  = ",";
	public static final String EMPTY 	  = "";
	public static final String SPACE 	  = " ";
	public static final String UNDER_BAR  = "_";
	public static final String OK         = "OK";
	public static final String UTF8 	  =  "utf-8";
	public static final String AES  	  =  "AES";
	public static final String RSA  	  =  "RSA";
	public static final String AES_CBC 	  =  "AES/CBC/PKCS5Padding";
	public static final String IS_Y 	  = "Y";
	public static final String IS_N 	  = "N";
	public static final String TRUE 	  = "true";
	public static final String FALSE      = "false";
	public static final String HOST       = "host";
	public static final String FMT_MMDD 				= "MMdd";
	public static final String FMT_YYYYMMDD 			= "yyyyMMdd";
	public static final String FMT_YYYYMMDD_DOT 		= "yyyy.MM.dd";
	public static final String FMT_YYYYMMDD_DASH        = "yyyy-MM-dd";
	public static final String FMT_YYYYMMDDHHMM			= "yyyyMMddHHmm";
	public static final String FMT_YYYYMMDDHHMM_DOT		= "yyyy.MM.dd HH:mm";
	public static final String FMT_YYYYMMDDHHMMSS		= "yyyyMMddHHmmss";
	public static final String FMT_YYYYMMDDHHMMSSMS		= "yyyyMMddHHmmssSSS";
	public static final String FMT_YYYYMMDDHHMMSS_DOT 	= "yyyy.MM.dd HH:mm:ss";
	public static final String FMT_YYYYMMDDHHMMSS_DASH 	= "yyyy-MM-dd HH:mm:ss";

	public static final long TIMEOUT                          = 0;
	public static final String TRACE_ID					= "traceId";
	public static final String PARAM_INFO				= "paramInfo";
	public static final String LOG_TYPE					= "logType";
	public static final String LOG_TYPE_LOG				= "log";
	public static final String PARAM_DATA				= "data";
	public static final String PARAM				    = "param";
	public static final String CODE_NAME			    = "CODE_NAME";
	public static final String CODE_VALUE			    = "CODE_VALUE";
	public static final String ETC_2	    		    = "etc2";
	public static final String RESIDENCE			    = "residence";
	public static final String COUNT			        = "count";
	public static final String DATE_TIME		        = "dateTime";
	public static final String LIST     		        = "list";

	public static final String PAGE     			    = "page";
	public static final String PAGE_SIZE  			    = "pageSize";
	public static final String INFO      			    = "info";
	public static final String PAGE_INFO  			    = "pageInfo";
	public static final String PAGE_TOTAL  			    = "pageTotal";
	public static final String TYPE     			    = "type";
	public static final String FILE     			    = "file";
	public static final String IMG       			    = "img";

	public static final String SUCCESS_CODE  			= "0000";  //성공
	public static final String FAIL_CODE  		     	= "9000";  //실패
	
	/** 시작시간/종료시간 */
	public static final String START_TIME = "000000"; // 000000
	public static final String END_TIME = "235959"; // 235959
	
	/** 결제관련 */
	public static final String PAY_AUTH_SUCCESS_CODE = "0000"; // 인증요청 성공
	public static final String PAY_CANCEL_SUCCESS_CODE = "2001"; // 취소요청 성공
	public static final String PAY_CANCEL_REFUND_SUCCESS_CODE = "2211"; // 환불 성공
	public static final String PAY_CARD_RESULT_CODE = "3001"; // 신용카드
	public static final String PAY_BANK_RESULT_CODE = "4000"; // 계좌이체
	public static final String PAY_VBANK_RESULT_CODE = "4100"; // 가상계좌
	public static final String PAY_VBANK_DEPOSIT_RESULT_CODE = "4110"; // 가상계좌 입금 성공
	
	/** JWT 토큰 */
	public static final String REQUEST_TYPE = "requestType";
	public static final String X_BBS_AT     = "X_BBS_AT";
	public static final String X_BBS_RT     = "X_BBS_RT";
	public static final String ACCESS_TOKEN = "accessToken";
	public static final String REFRESH_TOKEN = "refreshToken";
	
	/** 로그인 */
	public static final String ROOT_PATH = "/";
	public static final String LOGIN_PAGE_URL = "/login"; 
	public static final String LOGIN_PROCESSING_URL = "/auth/loginProcess"; 
	public static final String LOGIN_SUCCESS_URL = "/main";
	public static final String LOGOUT_URL = "/auth/logoutProcess";
	public static final String JSESSIONID = "JSESSIONID";

	/** 네이버맵 */
	public static final String NAVER_URL = "naverGeocodeUrl";    //네이버주소 API URL
	public static final String NAVER_ID  = "naverGeocodeKeyId";  //네이버주소 API 키 ID
	public static final String NAVER_KEY = "naverGeocodeKey";    //네이버주소 API 키
	
	/** 성공여부 */
	public static final String SUCC_YN = "succYn";

	/** Charset **/
	public class Charset {
		public static final String UTF8	= "utf-8";
	}

	/** ContentType **/
	public class ContentType {
		public class Application {
			public static final String JSON			= "application/json";
			public static final String JAVA_SCRIPT	= "application/javascript";
			public static final String FORM			= "application/x-www-form-urlencode";
		}
		
		public class Multipart {
			public static final String FORM			= "multipart/formed-data";
		}
		
		public class Text {
			public static final String CSS			= "text/css";
			public static final String HTML			= "text/html";
			public static final String JAVA_SCRIPT	= "text/javascript";
			public static final String PLAIN		= "text/plain";
			public static final String XML			= "text/xml";
		}
	}

	public enum HttpMethodType { POST, GET, DELETE }

	/** 사용자정보관련 **/
	public class UserInfo {
		public static final String USER_NO			  = "userNo";      //회원번호
		public static final String USER_ID			  = "userId";      //아이디
		public static final String USER_PW			  = "userPw";      //비밀번호
		public static final String USER_NAME		  = "userNm";      //이름
		public static final String USER_HP_NO	      = "userHpNo";    //휴대폰
		public static final String USER_EMAIL		  = "userEmail";   //이메일
		public static final String BROKERAGE_CD	      = "brokerageCd"; //대표 중개업소코드
		public static final String USER_BROKERAGE_CD  = "userBrokerageCd"; //중개업소코드
		public static final String BROKERAGE_NM	      = "brokerageNm"; //중개업소명
		public static final String USER_ROLE		  = "userRole";    //회원구분
		public static final String JOIN_STATUS		  = "joinStatus";   //가입상태

	}

	/** 시스템코드 **/
	public class SysCode {
		public static final String MEMUL_CODE   	= "memulCode";      //매물코드
		public static final String MEMUL_JONG   	= "memulJong";      //매물종류
		public static final String DIRECTION_BASE   = "directionBase";  //방향기준
		public static final String DIRECTION        = "direction";      //방향
		public static final String DOOR_TYPE        = "doorType";       //현관구조
		public static final String USE_YN           = "useYn";          //사용여부
		public static final String MNEX_ITEMS       = "mnexItems";      //월관리비항목
		public static final String LAWUSAGE_CODE    = "lawUsageCode";   //건축물용도
		public static final String CS_INQURIE		= "csInquire";  //1:1문의 문의유형
		public static final String OTEL_USAGE       = "otelUsage";      //용도
		public static final String DUPLEX_TYPE      = "duplexType";     //단층복층
		public static final String FLOOR_LEVEL      = "floorLevel";     //층레벨
		public static final String FLOOR_TYPE       = "floorType";      //층정보
		public static final String TRD_TYPE         = "trdType";        //거래종류
		public static final String LOAN_TYPE        = "loanType";       //융자금타입
		public static final String SALE_TYPE        = "saleType";       //분양권구분
		public static final String CUSTOMER_TRS     = "transactionType";    //고객리스트 거래유형
		
		public static final String NAVER_PROMOTE    = "naverType";     //네이버 홍보유형
        public static final String COOLING_FAC      = "coolingFac";     //냉방시설
        public static final String LIFE_FAC         = "lifeFac";        //생활시설
        public static final String SECURITY_FAC     = "securityFac";    //보안시설
        public static final String ETC_FAC          = "etcFac";         //기타시설
        public static final String ONEROOM_TYPE     = "oneroomType";    //원룸구조
        public static final String ONEROOM_FEATURE  = "oneroomFeature"; //원룸특징
        public static final String EXPS             = "exps";           //네이버부동산연락처노출
		public static final String RENT_PERIOD      = "rentPeriod";     //계약기간
		public static final String MEMUL_STATUS     = "memulStatus";    //매물상태
		public static final String ADDR_AREA        = "addrArea";       //주소위치
		public static final String EXPOSURE_YN      = "exposureYn";     //노출여부
		public static final String AINS             = "aIns";           //면적검수기준코드
		public static final String UNDER            = "Under";          //지하총층코드
		public static final String PARKING_YN       = "parkingYn";      //주차가능여부코드
		public static final String REDEV            = "reDev";          //재건축재개발여부코드
		public static final String ABUSE_INFO       = "abUseInfo";      //준공사용일정보코드
		public static final String STRUCTURE        = "structure";      //건축구조코드
		public static final String RE_COMM          = "recomm";         //추천업종코드
		public static final String POINT            = "point";          //지목코드
		public static final String USAGE            = "usage";          //용도지역코드
		public static final String POWER            = "power";          //동력코드
		public static final String OPTION           = "option";         //옵션코드
		public static final String REQUEST_TYPE     = "requestType";    //요청구분
		public static final String STATUS_TYPE      = "statusType";     //상태구분
		public static final String SCHD_TYPE        = "schdType";       //일정분류
		public static final String ALARM            = "alarm";          //알림
		public static final String LAND_TYPE        = "landType";       //대지권종류
		public static final String BUILD_STRUCTURE  = "buildStructure"; //건물구조
		public static final String BUILD_USAGE      = "buildUsage";     //건물용도
		public static final String ACCEPT_TYPE      = "acceptType";     //인수방식
		public static final String CONTRACTOR_TYPE  = "contractorType"; //계약인구분
		public static final String PRICE_MARK       = "priceMark";      //금액표시
		public static final String RECEIVE_SETTING  = "receiveSetting";     //수신설정
		public static final String ANSWER_YN        = "answerYn";     //수신설정
		public static final String RECEPTION_TYPE   = "receptionType";     //수신설정
		public static final String USER_TYPE        = "userType";       //회원구분
		public static final String JOIN_TYPE        = "joinType";       //가입구분
		public static final String JOIN_STATUS      = "joinStatus";     //가입상태
		public static final String AD_ADDR_TYPE     = "adAddrType";     //광고노출소재지주소구분
		public static final String EMAIL_DOMAIN     = "emailDomain";    //이메일 도메인
		public static final String USAGE_JIGU       = "usageJigu";      //용도지구
		public static final String USAGE_GUYORK     = "usageGuyork";    //용도구역
		public static final String HEAT_TYPE        = "heatType";       //난방방식
		public static final String HEAT_FUEL        = "heatFuel";       //난방연료
		public static final String NEW_BUILD        = "newBuild";       //신축빌라
		public static final String YES_NO           = "yesNo";          //예아니오
		public static final String BANG_OPTION1     = "bangOption1";    //방콜옵션1
		public static final String WITHDRAW_REASON  = "withdrawRsn";    //탈퇴사유
		public static final String GENDER 		    = "gender";         //성별
		public static final String AGE              = "age";            //나이
		public static final String SHARE_HOUSE_TYPE = "shareHouseType"; //쉐어하우스종류
		public static final String TREM             = "trem";           //기간
		public static final String AGE_CNT          = "ageCnt";         //나이선택
		public static final String PROCESS_TYPE     = "processType";    //처리구분
		public static final String RECPRO_TERM     = "recProTerm";     //네이버매물종류
		public static final String MEMUL_NAVER     = "memulNaver";     //접수처리기간
		public static final String BANK_CD = "bankCd"; // 은행(증권사) 코드
		public static final String CARD_CD= "cardCd"; // 카드 코드
	}

	/** 파라미터 **/
	public class Param {
		public static final String ADDR_AREA    	  	  	= "addrArea";
		public static final String ADDRESS      	  	  	= "Address";
		public static final String SANGTAE      	  	  	= "Sangtae";
		public static final String APT_LIST     	  	  	= "aptList";
		public static final String EX_LIST       	  	  	= "exList";
		public static final String IMG_MGMT_TOTAL  	  	  	= "imgMgmtTotal";
		public static final String IMG_MGMT_FOLDER 	  	  	= "imgMgmtFolder";
		public static final String IMG_MGMT_FOLDER_DETAIL 	= "imgMgmtFolderDetail";
		public static final String FOLDER_NAME            	= "folderName";
		public static final String FOLDER_NUMBER          	= "folderNumber";
		public static final String CODE1           		  	= "code_1";
		public static final String CODE2                  	= "code_2";
		public static final String ADDRAREA1       		  	= "addrArea_1";
		public static final String ADDRAREA2        	  	= "addrArea_2";
		public static final String GETDATE           	  	= "getDate";
		public static final String GOOD_NAME        	  	= "goodName";
		public static final String NAVER            	  	= "naver";
		public static final String BANG_CALL        	  	= "bangcall";
		public static final String DID	  	        	  	= "did";
		public static final String SERVICE_KEY            	= "ServiceKey";
		public static final String PAGE_NO           	  	= "pageNo";
		public static final String NUM_OF_ROWS        	  	= "numOfRows";
		public static final String LOCATADD_NM        	  	= "locatadd_nm";
		public static final String SIGNUNGU_CD        	  	= "sigunguCd";
		public static final String BJDONG_CD        	  	= "bjdongCd";
		public static final String PLATGB_CD        	  	= "platGbCd";
		public static final String BUN              	  	= "bun";
		public static final String JI               	  	= "ji";
		public static final String TOTAL_COUNT         	  	= "totalCount";
		public static final String MEMUL_TYPE_CODE     	  	= "memulTypeCode";
		public static final String MEMUL_TYPE         	  	= "memulType";
		public static final String ADDR             	  	= "addr";
		public static final String ADDR_1            	  	= "addr1";
		public static final String ADDR_2            	  	= "addr2";
		public static final String ADDR_3           	  	= "addr3";
		public static final String ADDR_4           	  	= "addr4";
		public static final String DETAIL_ADDR        	  	= "detailAddr";
		public static final String NUM_1            	  	= "1";
		public static final String NUM_3            	  	= "3";
		public static final String NUM_100            	  	= "100";
		public static final String NUM_10000           	  	= "10000";
		public static final String TYPE_XML           	  	= "xml";
		public static final String PHONE             	  	= "phone";
		public static final String PHONE_1            	  	= "phone1";
		public static final String PHONE_2            	  	= "phone2";
		public static final String PHONE_3           	  	= "phone3";
		public static final String NEW_CNT           	  	= "newCnt";
		public static final String GROUP_NUMBER     	  	= "groupNumber";
		public static final String GROUP_INVITE_LIST      	= "groupInviteList";
		public static final String GROUP_INVITE_MEMBER_LIST	= "groupInviteMemberList";
		public static final String GROUP_JOIN_LIST        	= "groupJoinList";
		public static final String GROUP_HOME_HEADER      	= "groupHomeHeader";
		public static final String GROUP_HOME_INFO        	= "groupHomeInfo";
		public static final String ACTIVE				  	= "active";
		public static final String APT_ETC_CODE				= "p_apt";
		public static final String STANREGIN_CD				= "StanReginCd";
		public static final String EXPOSPCN  				= "exposPubuseGbCdNm";
		public static final String HO_NM     				= "hoNm";
		public static final String SUPPLY_CNT  				= "supplyCnt";
		public static final String PUBLIC_CNT  				= "publicCnt";
		public static final String JUNYU_HAN  				= "전유";
		public static final String PUBLIC_HAN  				= "공용";
		public static final String REGION_CD  				= "region_cd";
		public static final String TOT_AREA  				= "totArea";
		public static final String PLAT_AREA  				= "platArea";
		public static final String ARCH_AREA  				= "archArea";
		public static final String AREA      				= "area";
		public static final String FILE_NO     				= "fileNo";
		public static final String FILE_NM     				= "fileNm";
		public static final String OWNER      				= "owner";
		public static final String CREATE_ID     			= "createId";
		public static final String CREATE_DT     			= "createDt";
		public static final String UPDATE_ID     			= "updateId";
		public static final String UPDATE_DT     			= "updateDt";
		public static final String REQUEST     				= "request";
		public static final String CONTRACT_NO     			= "contractNo";
		public static final String TOTAL_CNT     			= "totalCnt";
		public static final String PAGE_FUNCTION     		= "pageFunction";
		public static final String OFFICE_ID     			= "officeId";
		public static final String RENEWAL_ID     			= "renewalId";
		public static final String AUTH_DT     				= "authDt";
		public static final String ACCOUNT_INFO     		= "accountInfo";
		public static final String PROFILE     				= "profile";
		public static final String MEMUL_NAME  			    = "memulName";
		public static final String MEMUL_CNT  				= "memulCnt";
		public static final String REALTY_SEQ  				= "RealtySeq";
		public static final String UNIQUE_NO  				= "UniqueNo";
		public static final String JI_BEON  				= "BudongsanSojaejibeon";
		public static final String IROS_ID  				= "IrosID";
		public static final String IROS_PWD  				= "IrosPwd";
		public static final String EMONEY_NO_1 				= "EmoneyNo1";
		public static final String EMONEY_NO_2 				= "EmoneyNo2";
		public static final String EMONEY_PWD 				= "EmoneyPwd";
		public static final String A103_NAME 				= "A103Name";
		public static final String TRANSACTION_KEY   		= "TransactionKey";
		public static final String SUBJECT 					= "subject";
		public static final String BODY 					= "body";
		public static final String ETC1 					= "etc1";
		public static final String ETC2 					= "etc2";
		public static final String ETC3 					= "etc3";
		public static final String SUCCYN 					= "succYn";
		public static final String MSG  					= "msg";
		public static final String FILE_PATH				= "filePath";
		public static final String MEMUL_JONG1   			= "memulJong1";      //매물종류1
		public static final String MEMUL_JONG2   			= "memulJong2";      //매물종류2
	}

	/* URL */
	public class URL {
		public static final String MEMUL_REG				= "memul/memulMgmt/memulReg";
	}

	/** 카카오알림톡 **/
	public class Kakao {
		public static final String SENDER_KEY     			= "sender_key";  //Sender키
		public static final String PHONE     				= "phone";       //수신번호
		public static final String TMPL_CD     				= "tmpl_cd";     //템플릿코드
		public static final String SEND_MSG     			= "send_msg";    //메세지본문
		public static final String REQ_DATE     			= "req_date";    //발송일시
		public static final String CUR_STATE     			= "cur_state";   //상태
		public static final String SMS_TYPE     			= "sms_type";    //타입
		public static final String CALL_BACK     			= "callback";    //발신번호
		public static final String SUBJECT     				= "subject";     //메시지제목
	}
	
}


