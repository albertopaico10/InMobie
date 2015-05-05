package com.rest.web.service.inmobile.util;

public class CommonConstants {

	public class CodeResponse{
		public final static String CODE_RESPONSE_ERROR="ERROR";
		public final static String CODE_RESPONSE_SUCCESS_USER="SUCCESS_INSERT_USER";
		public final static String CODE_RESPONSE_SUCCESS_VALIDATION="SUCCESS_VALIDATION_USER";
		public final static String CODE_RESPONSE_FAIL_VALIDATION="FAIL_VALIDATION_USER";
		public final static String CODE_RESPONSE_EXITS_USER="EMAIL_EXIST";
		public final static String CODE_RESPONSE_NOT_EXITS_USER="EMAIL_NOT_EXIST";
		public final static String CODE_RESPONSE_IS_PROVIDER="IS_PROVIDER";
		public final static String CODE_RESPONSE_IS_RESTAURANT="IS_RESTAURANT";
		public final static String CODE_RESPONSE_ACCOUNT_INACTIVE="ACCOUNT_INACTIVE";
		public final static String CODE_RESPONSE_ACCOUNT_PENDING_VALDATION="ACCOUNT_PENDING_VALDATION";
		public final static String CODE_RESPONSE_SUCCESS_DEPARTMENT="SUCCESS_DEPARTMENT";
		public final static String CODE_RESPONSE_SUCCESS_PROVINCE="SUCCESS_PROVINCE";
		public final static String CODE_RESPONSE_SUCCESS_DISTRICT="SUCCESS_DISTRICT";
		public final static String CODE_RESPONSE_SUCCESS_IMAGE="SUCCESS_INSERT_IMAGE";
	}
	
	public class Email{
		public final static String EMAIL_FROM="albertopaico10@gmail.com";
		public final static String PASSWORD_FROM="Pa55w0rd4097";
		public final static String SUBJECT_CREATION_USER="InMobile - Creation User";
		public final static String EMAIL_TRUE="true";
		public final static String EMAIL_SMTP_GMAIL="smtp.gmail.com";
		public final static String EMAIL_PORT_GMAIL="587";
	}
	
	public class ValueRequestMapping{
		public static final String CREATE_USER = "/rest/user/create";
		public static final String VALIDATE_USER = "/rest/user/validation";
		public static final String ACTIVATE_USER = "/rest/user/activate";
		public static final String SAVE_RESTAURANT = "/rest/restaurant/save";
		public static final String SAVE_PROVIDER = "/rest/provider/save";
		public static final String LIST_DEPARTMENTS = "/rest/list/departments";
		public static final String LIST_PROVINCE = "/rest/list/province/{id}";
		public static final String LIST_DISTRICT = "/rest/list/district/{id}";
		public static final String SAVE_IMAGE = "/rest/image/save";
	}
	
	public class EncriptedValues{
		public static final String ALGORITHM_MD5="MD5";
		public static final String KEY_VALUE_ENCRIPTED="inMobileKeyPublic";
	}
	
	public class ValuesProject{
		public static final String URL_SERVER="http://localhost:8080/";
		public static final String PROJECT_VALUE="InMobileWeb/";
		public static final String ACTION_CONTINUE="continue.htm?val=";
	}
	
	public class TypeOperationReqResp{
		public static final String OPERATION_CREATE_USER="CREATE_USER";
		public static final String OPERATION_VALIDATE_USER="VALIDATE_USER";
		public static final String OPERATION_SAVE_RESTAURANT="SAVE_RESTAURANT";
		public static final String OPERATION_SAVE_PROVIDER = "SAVE_PROVIDER";
	}
	
}
