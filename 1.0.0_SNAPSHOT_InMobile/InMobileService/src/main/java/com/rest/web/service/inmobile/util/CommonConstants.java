package com.rest.web.service.inmobile.util;

public class CommonConstants {

	public class CodeResponse{
		public final static String CODE_RESPONSE_ERROR="ERROR";
		public final static String CODE_RESPONSE_SUCCESS_USER="SUCCESS_INSERT_USER";
		public final static String CODE_RESPONSE_SUCCESS_VALIDATION="SUCCESS_VALIDATION_USER";
		public final static String CODE_RESPONSE_FAIL_VALIDATION="FAIL_VALIDATION_USER";
		public final static String CODE_RESPONSE_EXITS_USER="EMAIL_EXIST";
		public final static String CODE_RESPONSE_NOT_EXITS_USER="EMAIL_NOT_EXIST";
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
	}
	
	public class EncriptedValues{
		public static final String ALGORITHM_MD5="MD5";
		public static final String KEY_VALUE_ENCRIPTED="inMobileKeyPublic";
	}
	
	public class ValuesProject{
		public static final String URL_SERVER="http://localhost:8080/";
		public static final String PROJECT_VALUE="InMobileWeb/";
		public static final String ACTION_CONTINUE="continue.htm?id=";
	}
	
	public class TypeOperationReqResp{
		public static final String OPERATION_CREATE_USER="CREATE_USER";
		public static final String OPERATION_VALIDATE_USER="VALIDATE_USER";
	}
	
}
