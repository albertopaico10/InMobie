package com.inmobile.web.util;

public class CommonConstants {

	public class Page{
		public static final String REDIRECT_INIT_PAGE="initPage";
		public static final String REDIRECT_LOGIN_PAGE="loginPage";
		public static final String REDIRECT_PROVIDER="providerPage";
		public static final String REDIRECT_RESTAURANT="restaurantPage";
		public static final String REDIRECT_SENDEMAIL="sendEmailPage";
		public static final String REDIRECT_INACTIVE_ACCOUNT_PAGE="inactiveAccountPage";
		public static final String REDIRECT_ERROR="errorPage";
		public static final String REDIRECT_ACCOUNT_PENDING="accountPendingPage";
	}
	
	public class Response{
		public static final String RESPONSE_USER_SUCCESS="SUCCESS_INSERT_USER";
		public static final String RESPONSE_USER_EXIST="EMAIL_EXIST";
		public static final String RESPONSE_ERROR="ERROR";
		public final static String RESPONSE_SUCCESS_VALIDATION="SUCCESS_VALIDATION_USER";
		public final static String RESPONSE_FAIL_VALIDATION="FAIL_VALIDATION_USER";
		public final static String RESPONSE_NOT_EXITS_USER="EMAIL_NOT_EXIST";
		public final static String RESPONSE_IS_RESTAURANT="IS_RESTAURANT";
		public final static String RESPONSE_IS_PROVIDER="IS_PROVIDER";
		public final static String RESPONSE_ACCOUNT_INACTIVE="ACCOUNT_INACTIVE";
		public final static String RESPONSE_ACCOUNT_PENDING_VALIDATION="ACCOUNT_PENDING_VALDATION";
	}
	public class Logger{
		public static final String LOGGER_START="****START****";
		public static final String LOGGER_END="****END****";
	}
	
	public class URLService{
		public static final String URL_REGISTER_USER="http://localhost:8080/InMobileService/rest/user/create";
		public static final String URL_VALIDATION_USER="http://localhost:8080/InMobileService/rest/user/validation";
		public static final String URL_ACTIVATE_USER="http://localhost:8080/InMobileService/rest/user/activate";
		public static final String URL_SAVE_RESTAURANT="http://localhost:8080/InMobileService/rest/restaurant/save";
	}
	
	public class EncriptedValues{
		public static final String ALGORITHM_MD5="MD5";
		public static final String KEY_VALUE_ENCRIPTED="inMobileKeyPublic";
	}
	
	public class WebId{
		public static final String LOGIN_REGISTER_USER="register";
	}
}
